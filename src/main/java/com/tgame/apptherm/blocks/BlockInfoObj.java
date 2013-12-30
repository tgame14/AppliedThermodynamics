package com.tgame.apptherm.blocks;

public class BlockInfoObj {

	public int Id;
	private int Default;
	private String Key;
	private String Name;
	private String UnlocalizedName;
	private String TeKey;
	private String[] Textures;

	public BlockInfoObj(int Default, String Key, String Name,
			String UnlocalizedName, String TeKey, String[] Textures) {

		this.Default = Default;
		this.Key = Key;
		this.Name = Name;
		this.UnlocalizedName = UnlocalizedName;
		this.TeKey = TeKey;
		this.Textures = Textures;

	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getDefault() {
		return this.Default;
	}

	public void setDefault(int Default) {
		this.Default = Default;
	}

	public String getKey() {
		return this.Key;
	}

	public void setKey(String Key) {
		this.Key = Key;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getUnlocalizedName() {
		return this.UnlocalizedName;
	}

	public void setUnlocalizedName(String UnlocalizedName) {
		this.UnlocalizedName = UnlocalizedName;
	}

	public String getTeKey() {
		return this.TeKey;
	}

	public void setTeKey(String TeKey) {
		this.TeKey = TeKey;
	}

	public String[] getTextures() {
		return this.Textures;
	}

	public void setTextures(String[] Textures) {
		this.Textures = Textures;
	}

}
