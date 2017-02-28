import java.util.HashSet;
import java.util.Hashtable;

public class TrieNode {
	public char c;
	public Hashtable<Character, TrieNode> children;
	public boolean isLeaf;

	public TrieNode() {
		c = ' ';
		children = new Hashtable<Character, TrieNode>();
		isLeaf = false;
	}

	public TrieNode(char data) {
		c = data;
		children = new Hashtable<Character, TrieNode>();
		isLeaf = false;
	}

	public boolean addChild(char child) {
		if (children.containsKey(child)){
			return false;
		}else{
			this.children.put(child, new TrieNode(child));
			return true;
		}
			
		
	}

	public boolean hasChild(char child) {
		return children.containsKey(child);
	}

	public TrieNode getChild(char child) {
		return this.children.get(child);
	}

	public String toString() {
		HashSet<String> hs = new HashSet<String>();
		toStringHelper(hs, this, "");
		return hs.toString();
	}

	public void toStringHelper(HashSet<String> hs, TrieNode n, String prefix) {

		if (n.isLeaf){
			hs.add((prefix + n.c).trim());
		}	
		if (!n.children.isEmpty()) {
			for (TrieNode tn : n.children.values()) {
				toStringHelper(hs, tn, prefix + n.c);
			}
		}
	}

}