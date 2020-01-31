class Phone_book {
    
    public boolean solution(String[] phone_book) {        
        for(int i = 0 ; i < phone_book.length ; i++)
            for(int j = i + 1 ; j < phone_book.length ; j++){
                if(phone_book[i].length() <= phone_book[j].length()){
                    if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))){
                        return false;
                    }
                }
                else{
                    if(phone_book[j].equals(phone_book[i].substring(0, phone_book[j].length()))){
                        return false;
                    }
                }
            }
        return true;
    }
}