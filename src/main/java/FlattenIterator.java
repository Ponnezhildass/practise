import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenIterator {
    interface NestedInteger {

             // @return true if this NestedInteger holds a single integer, rather than a nested list.
               boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              List<NestedInteger> getList();
  }

  class NestedIntegerImpt implements NestedInteger{

      List<NestedInteger> list;
      int number;
      String type;

      public NestedIntegerImpt(List<NestedInteger> list) {
          this.list = list;
          type = "List";
      }

      public NestedIntegerImpt(int number) {
          this.number = number;
          type = "Number";
      }

      @Override
      public boolean isInteger() {
          if(type.equals("Number"))
            return true;
          else return false;
      }

      @Override
      public Integer getInteger() {
          if(type.equals("Number"))
            return number;
          else return null;
      }

      @Override
      public List<NestedInteger> getList() {
          if(type.equals("Number"))
              return null;
          else
            return list;
      }
  }

  class NestedIterator implements Iterator<Integer> {

      Stack<Iterator<NestedInteger>> stack = new Stack<>();

      public NestedIterator(List<NestedInteger> nestedList) {
          stack.push(nestedList.listIterator());
      }

      @Override
      public boolean hasNext() {
          if(stack.isEmpty()) return false;
          else if(stack.peek().hasNext()){
              return true;
          } else {
              stack.pop();
              return hasNext();
          }
      }

      @Override
      public Integer next() {
          if(stack.peek().hasNext()){
              NestedInteger i = stack.peek().next();
              if(i.isInteger()) return i.getInteger();
              else {
                  stack.push(i.getList().listIterator());
                  return next();
              }
          }
          return null;
      }
  }

  public static void main(String[] args){
        FlattenIterator flattenIterator = new FlattenIterator();
        List<NestedInteger> list = new ArrayList<>();
        list.add(flattenIterator.new NestedIntegerImpt(3));
        NestedInteger temp = flattenIterator.new NestedIntegerImpt(4);
        list.add(temp);

        NestedIterator nestedIterator = flattenIterator.new NestedIterator(list);
        while(nestedIterator.hasNext()){
            System.out.println(nestedIterator.next());
        }
  }
}
