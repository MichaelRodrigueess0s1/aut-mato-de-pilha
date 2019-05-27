package estruturas;

public class SimpleStack {  
    /**  
     * Vetor de String que armazenar� os elementos.  
     * Se uma posicao estiver nula, esta posicao sera encarada como uma posicao  
     * vazia na pilha. Sendo assim, nunca poder� existir uma posi��o vazia   
     * seguida de uma posi��o n�o-vazia(diferente de null), pois isso indicaria   
     * que, de alguma forma, removemos algum elemento da pilha que n�o o do topo.  
     */    
    private Character[] elements;    
    /**  
     * inteiro que indicar� quantos elementos N�O NULOS existem dentro de   
     * elements. Note por exemplo que:  
     * -Se size for igual a 26, o topo da pilha est� na posi��o 25 de elements  
     * -Se size for igual a 10, o topo da pilha est� na posi��o 9 de elements  
     * -Se size for igual a n, o topo da pilha est� na posi��o (n - 1) de elements  
     * Resumindo, podemos assumir QUASE sempre que o topo da pilha � a posi��o   
     * (size - 1) de elements.  
     * O "quase" se deve ao caso de quando nossa pilha � vazia. Nesse caso,   
     * size � igual a 0. Se fossemos seguir a regra acima indistintamente,   
     * acabar�amos assumindo que neste caso o topo da pilha est� na posi��o -1   
     * de elements, o que � um erro... Trata-se ent�o de uma exce��o, a qual   
     * deveremos estar atentos para fazer bobagem!  
     * Para fins did�ticos, criaremos um m�todo privado que retorna a posi��o   
     * exata do topo da pilha, e sempre utilizaremos este m�todo para termos tal  
     * informa��o.  
     */    
    private int size;    
      
    /**  
     * Construtor que recebe um int como par�metro, indicando qual ser� a   
     * capacidade da pilha rec�m-instanciada  
     */    
    public SimpleStack(int capacity) {    
        /*  
        * Utilizamos o m�todo abs da classe Math s� pra evitar que se tente   
        * criar uma pilha "devedora"...  
        */    
        elements = new Character[Math.abs(capacity)];    
        size = 0;    
    }    
        
    /**  
     * M�todo utilizado para adicionar elementos � nossa pilha. Este elemento   
     * sempre ser� inserido no topo deta pilha.  
     * -Se o elemento for null, vamos lan�ar uma exce��o, informando que nossa   
     * pilha n�o aceita null como elemento v�lido.  
     * -Se a pilha estiver cheia, retornamos null para indicar que n�o foi   
     * poss�vel insirir elemento.  
     * -Se o elemento for inserido com sucesso, retornamos o pr�prio elemento,   
     * indicando assim o sucesso da opera��o  
     */    
    public Character push(Character element) {    
        if(element == null)    
            throw new IllegalArgumentException("O elemento não pode ser nulo!");    
           
        if(size == elements.length)    
            return null;    
           
        size++;    
        elements[getTopPosition()] = element;    
        return element;    
    }    
        
    /**  
     * Metodo utilizado para se obter o elemento que esta no topo desta pilha,   
     * porem, sem removo-lo da mesma.  
     * -Se a pilha estiver vazia, retornamos null para indicar que a pilha   
     * esta vazia.  
     * -Se houver ao menos um elemento na pilha, o elemento que esta no topo   
     * sera retornado, indicando o sucesso da operacao  
     */    
    public Character peek() {    
        if(isEmpty())    
            return null;    
           
        return elements[getTopPosition()];    
    }    
        
    /**  
     * Método utilizado para retirar("destacar") um elemento desta pilha. Este   
     * elemento sempre será aquele que se encontra no topo desta pilha.  
     * -Se a pilha estiver vazia, retornamos null para indicar que a pilha   
     * está vazia.  
     * -Se houver ao menos um elemento na pilha, o elemento que está no topo   
     * será retornado, indicando o sucesso da operação  
     */    
    public Character pop() {  
        Character result = peek();    
        /*Se havia um elemento no topo da pilha...*/    
        if(result != null) {    
            elements[getTopPosition()] = null;    
            size--;    
        }    
        return result;    
    }    
        
    /**  
     * Método utilizado para limpar todo o conteúdo da pilha.  
     */    
    public void clear() {    
        for(int i = 0; i < size; i++)    
            elements[i] = null;    
        size = 0;    
    }    
        
    /** 
     * Metodo utilizado para se obter o tamanho (nomero de elementos) da pilha  
     */    
    public int getSize() {    
        return size;    
    }    
        
    /**  
     * Metodo utilizado para se obter a capacidade da pilha  
     */    
    public int getCapacity() {    
        return elements.length;    
    }  
      
    /** 
     * Método utilizado para verificar se a pilha está vazia. Se for o caso,  
     * será retornado true, caso contrário, será retornado false. 
     */  
    public boolean isEmpty() {  
        return size <= 0;  
    }  
        
    /**  
     * Este método tem uma finalidade estritamente didática, visando facilitar o   
     * entendimento do código desta classe.  
     * Este método retorna um inteiro que representa a posiçãoo de elements onde   
     * se encontra o ultimo elemento inserido nesta pilha (O topo da pilha)  
     */    
    private int getTopPosition() {  
        if (isEmpty())  
            return 0;  
        return size - 1;    
    }  
      
    /**  
     * Este metodo serve para representar textualmente esta pilha  
     * @see java.lang.Object#toString()  
     */    
    public String toString() {    
        StringBuilder sb = new StringBuilder("[");    
        for(int i = 0; i < size; i++) {    
            sb.append(elements[i]);    
            if(i < size - 1)    
              sb.append(" | ");    
        }    
        sb.append(">");    
           
        return sb.toString();    
    }    
}  