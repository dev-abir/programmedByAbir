package Models;

public class RawModel {
	
	private int VAOID;
	private int nVertices;
	
	public RawModel(int VAOID, int nVertices){
		this.VAOID = VAOID;
		this.nVertices = nVertices;
	}

	public int getVAOID() {
		return VAOID;
	}

	public int getnVertices() {
		return nVertices;
	}
}
