package com.pennapps.feedDJ;

public class Song {
	private int ID;
	private String title;
	private String artist;
	private int votes; //-1 = not yet updated
	private int thumbsUp; //-1 = not yet updated
	private int thumbsDown; //-1 = not yet updated
	private short isFuture;
	private short wasVoted;
	private short wasRated;
	private short rating; //0=thumbsDown 1=thumbsUp
	
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.votes = -1;
		this.thumbsUp = -1;
		this.thumbsDown = -1;
		this.isFuture = 0;
		this.wasVoted = 0;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}

	/**
	 * @return the votes
	 */
	public int getVotes() {
		return votes;
	}

	/**
	 * @param thumbsUp the thumbsUp to set
	 */
	public void setThumbsUp(int thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	/**
	 * @return the thumbsUp
	 */
	public int getThumbsUp() {
		return thumbsUp;
	}

	/**
	 * @param thumbsDown the thumbsDown to set
	 */
	public void setThumbsDown(int thumbsDown) {
		this.thumbsDown = thumbsDown;
	}

	/**
	 * @return the thumbsDown
	 */
	public int getThumbsDown() {
		return thumbsDown;
	}

	/**
	 * @param isFuture the isFuture to set
	 */
	public void setFuture(short isFuture) {
		this.isFuture = isFuture;
	}

	/**
	 * @return the isFuture
	 */
	public short isFuture() {
		return isFuture;
	}

	/**
	 * @param wasVoted the wasVoted to set
	 */
	public void setWasVoted(short wasVoted) {
		this.wasVoted = wasVoted;
	}

	/**
	 * @return the wasVoted
	 */
	public short isWasVoted() {
		return wasVoted;
	}

	/**
	 * @param wasRated the wasRated to set
	 */
	public void setWasRated(short wasRated) {
		this.wasRated = wasRated;
	}

	/**
	 * @return the wasRated
	 */
	public short isWasRated() {
		return wasRated;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(short rating) {
		this.rating = rating;
	}

	/**
	 * @return the rating
	 */
	public short isRating() {
		return rating;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	
	
}
