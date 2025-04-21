class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        
        // - _ . => "" 
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // .. => .
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        // . never start
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        
        // empty => a
        if (new_id.length() == 0) new_id = "a";
        
        // max 15 cut
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        
        // . never end
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // under 2 => repeat last
        if(new_id.length() <=2){
            String last = String.valueOf(new_id.charAt(new_id.length() - 1));
            while(new_id.length() < 3){
                new_id += last;
            }
        }
        
        return new_id;
    }
}