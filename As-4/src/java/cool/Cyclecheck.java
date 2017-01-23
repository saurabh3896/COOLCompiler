package cool;

import java.util.*;

public class Cyclecheck{
  static int mod_v;
  static List<int[]> cycles;
  static List<Integer> cycle_nodes;
  static int [][] graph;

  public Cyclecheck(int [][] input_graph, int no_of_edges){
    graph = input_graph;
    cycle_nodes = new ArrayList<>();
    cycles = new ArrayList<>();
    mod_v = no_of_edges;
  }

  static Boolean equals(int[] a, int[] b){
    Boolean ret = (a[0] == b[0]) && (a.length == b.length);
      for(int i = 1;ret && (i < a.length);i++){
        if(a[i] != b[i]){
          ret = false;
        }
      }
    return ret;
  }

  static int[] invert(int[] path){
    int[] p = new int[path.length];
    for(int i = 0; i < path.length; i++){
      p[i] = path[path.length - 1 - i];
    }
    return normalize(p);
  }

  static int[] normalize(int[] path){
    int[] p = new int[path.length];
    int x = smallest(path);
    int n;

    System.arraycopy(path, 0, p, 0, path.length);

    while(p[0] != x){
      n = p[0];
      System.arraycopy(p, 1, p, 0, p.length - 1);
      p[p.length - 1] = n;
    }
    return p;
  }

  static Boolean isNew(int[] path){
    Boolean ret = true;
    for(int[] p : cycles){
      if(equals(p, path)){
        ret = false;
        break;
      }
    }
    return ret;
  }

  static int smallest(int[] path){
    int min = path[0];
    for(int p : path){
      if(p < min){
        min = p;
      }
    }
    return min;
  }

  static Boolean visited(int n, int[] path){
    Boolean ret = false;
      for(int p : path){
        if(p == n){
          ret = true;
          break;
        }
      }
    return ret;
  }

  static void findNewCycles(int[] path){
    int n = path[0];
    int x;
    int[] sub = new int[path.length + 1];
    for(int i = 0;i < graph.length;i++){
      for(int y = 0;y <= 1;y++){
        if(graph[i][y] == n){
          x = graph[i][(y + 1) % 2];
          if(!visited(x, path)){
            sub[0] = x;
            System.arraycopy(path, 0, sub, 1, path.length);
            findNewCycles(sub);
          }
          else if((path.length > 2) && (x == path[path.length - 1])){
            int[] p = normalize(path);
            int[] inv = invert(p);
            if(isNew(p) && isNew(inv)){
              cycles.add(p);
            }
          }
        }
      }
    }
  }

  public static boolean edge_exists(int array[], int matrix[][]){
    boolean flag = false;
    for(int [] row : matrix){
      if((array[0] == row[1] && array[1] == row[0]) || (array[0] == row[0] && array[1] == row[1])){
        flag = true;
        return flag;
      }
    }
    return flag;
  }

  public static boolean check(){
    for(int i = 0; i < graph.length; i++){
      for(int j = 0; j < graph[i].length; j++){
        findNewCycles(new int[] {graph[i][j]});
      }
    }
    for(int[] cy : cycles){
      cycle_nodes.add(cy[0]);
      for(int i = 1;i < cy.length;i++){
        cycle_nodes.add(cy[i]);
      }
    }
    for(int i = 0;i < mod_v;i++){
      int [] temp = graph[i];
      if(temp[0] == temp[1]){
        cycle_nodes.add(temp[0]);
      }
      for(int j = i + 1;j < mod_v;j++){
        int [] temp_ = graph[j];
        if(temp[1] == temp_[0] && temp[0] == temp_[1]){
          cycle_nodes.add(temp[0]);
          cycle_nodes.add(temp[1]);
        }
      }
    }
    Set<Integer> set = new HashSet<Integer>();
    for(int array[] : graph){
      for(Integer b : array){
        set.add(b);
      }
    }
    List<Integer> additional_nodes = new ArrayList<>();
    for(Integer i : set){
      if(cycle_nodes.size() == 0){
        break;
      }
      if(!cycle_nodes.contains(i)){
        for(Integer node : cycle_nodes){
          int [] poss_edge = {i, node};
          if(edge_exists(poss_edge, graph)){
            additional_nodes.add(i);
          }
        }
      }
    }
    if(cycle_nodes.size() != 0){
      cycle_nodes.addAll(additional_nodes);
    }
    return (cycle_nodes.size() != 0);
  }
}
