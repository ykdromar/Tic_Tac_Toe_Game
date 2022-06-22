public class player {
    private String name;
    private char symbol;
    public player(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name ){
        if(!name.isEmpty()){
            this.name=name;
        }
    }
    public char getSymbol(){
        return this.symbol;
    }
    public void setSymbol(char symbol){
        if(symbol!='\0'){
            this.symbol=symbol;
        }
    }
}
