class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, ArrayList<Integer>> secretMap = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> guessMap = new HashMap<>();

        int bulls = 0;  //digits that are in correct position.
        int cows = 0; // digits which are located in wrong position.

        for(int i = 0; i < secret.length(); i++){
            char key = secret.charAt(i);

            if(secretMap.containsKey(key)){
                ArrayList<Integer> list = secretMap.get(key);
                list.add(i + 1);
                secretMap.put(key, list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                secretMap.put(key, list);
            }
        }


        for(int i = 0; i < guess.length(); i++){
            char key = guess.charAt(i);

            if(guessMap.containsKey(key)){
                ArrayList<Integer> list = guessMap.get(key);
                list.add(i + 1);
                guessMap.put(key, list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                guessMap.put(key, list);
            }
        }

        for(Character key : guessMap.keySet()){
            if(secretMap.containsKey(key)){  
                ArrayList<Integer> secretPositions = secretMap.get(key);
                ArrayList<Integer> guessPositions = guessMap.get(key);

                int i = 0; 
                int j = 0;
                int tempBulls = 0;
                int tempCows = 0;

                while(i < secretPositions.size() && j < guessPositions.size()){
                    int secretPos = secretPositions.get(i);
                    int guessPos = guessPositions.get(j);

                    if(secretPos == guessPos){
                        i++;
                        j++;
                        tempBulls++;
                    }else if(secretPos < guessPos){
                        i++;
                    }else if(secretPos > guessPos){
                        j++;
                    }

                    
                }

                if(secretPositions.size() <= guessPositions.size()){
                    tempCows = secretPositions.size() - tempBulls; 
                }else{
                    tempCows = guessPositions.size() - tempBulls;
                }

                bulls += tempBulls;
                cows+= tempCows;
            }
        }


        String result = bulls + "A" + cows + "B"; 
        return result;
    }
}