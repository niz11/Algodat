import org.junit.Test;
import org.junit.Assert;

public class UnionFindTest {

  @Test
  public void testUnionFindAddElements(){
	  
	UnionFindSet<Integer> ufd = new UnionFindSet<Integer>();
	UnionFindSet<Node> ufd2 = new UnionFindSet<Node>();
	//Create a partition from 1
	ufd.add(1);
	Assert.assertEquals("Element 1 in first partition  does not have itself as the representative",(Integer)1,ufd.getRepresentative(1));
	
	//Create a partition from 2 
	ufd.add(2);
	Assert.assertEquals("Element 2 in second partition does not have itself as representant",(Integer)2,ufd.getRepresentative(2));
  }
  
  @Test
  public void testUnionFindMaintainPartition(){
	  
	UnionFindSet<Integer> ufd = new UnionFindSet<Integer>();
    
	ufd.add(1);
	ufd.add(2);
	ufd.add(3);
	ufd.add(10);
	
	//do one merge
	ufd.union(1, 2);
	Assert.assertNotEquals("The elements 1 and 3 are NOT different partitions (have the same representative)",ufd.getRepresentative(1),ufd.getRepresentative(3));	
	Assert.assertNotEquals("The elements 2 and 3 are NOT different partitions (have the same representative)",ufd.getRepresentative(2),ufd.getRepresentative(3));
	Assert.assertEquals("The elements 1 and 2  (have the same representative)",ufd.getRepresentative(1),ufd.getRepresentative(2));
	ufd.union(1, 3);
	ufd.union(1, 4);
	Assert.assertEquals("The elements 3 and 4  (have the same representative)",ufd.getRepresentative(3),ufd.getRepresentative(4));
	
  }


  @Test
  public void testUnionFindUnionOnElements(){
	  
	UnionFindSet<Integer> ufd = new UnionFindSet<Integer>();
    
	ufd.add(1);
	ufd.add(2);
	ufd.add(3);
	ufd.add(4);
	ufd.add(5);
	
	//merge all
	ufd.union(1, 2);
	ufd.union(1, 3);
	ufd.union(3, 4);
	ufd.union(4, 5);
	Assert.assertEquals("The elements 1 and 3 are not in the same partition",ufd.getRepresentative(1),ufd.getRepresentative(3));	
	Assert.assertEquals("The elements 1 and 4 are not in the same partition",ufd.getRepresentative(1),ufd.getRepresentative(4));	
	Assert.assertEquals("The elements 1 and 5 are not in the same partition",ufd.getRepresentative(1),ufd.getRepresentative(5));	
  }
  
  
  
  @Test
  public void testUnionFindUnionOnRepresentatives(){
	  
	UnionFindSet<Integer> ufd = new UnionFindSet<Integer>();
    
	ufd.add(1000);
	ufd.add(1);
	ufd.add(100);
	ufd.add(10);
	
	//merge all
	ufd.union(1, 10);
	ufd.union(1, 100);
	ufd.union(1, 1000);
	Assert.assertEquals("The elements 1 and 10 are not in the same partition",ufd.getRepresentative(1),ufd.getRepresentative(10));	
	Assert.assertEquals("The elements 1 and 100 are not in the same partition",ufd.getRepresentative(1),ufd.getRepresentative(100));	
	Assert.assertEquals("The elements 1 and 1000 are not in the same partition",ufd.getRepresentative(1),ufd.getRepresentative(1000));	
  }
  @Test
  public void testUnionFindAddNodes(){
	  
	UnionFindSet<Node> ufd2 = new UnionFindSet<Node>();
	Node a1 = new Node(1);
	Node a2 = new Node(2);
	Node a3 = new Node(3);
	Node a4 = new Node(4);
	//Create a partition from 1
	ufd2.add(a1);
	Assert.assertEquals("Element 1 in first partition  does not have itself as the representative",a1,ufd2.getRepresentative(a1));
	
	//Create a partition from 2 
	ufd2.add(a2);
	Assert.assertEquals("Element 2 in second partition does not have itself as representant",a2,ufd2.getRepresentative(a2));
	
	ufd2.union(a1, a2);
	ufd2.union(a1, a3);
	ufd2.union(a3, a4);
	//System.out.println(ufd2.getRepresentative(a1));
	//System.out.println(ufd2.getRepresentative(a2));
	//System.out.println(ufd2.getRepresentative(a3));
	//System.out.println(ufd2.getRepresentative(a4));
  }
  
  
  
}

