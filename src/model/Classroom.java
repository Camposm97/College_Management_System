package model;

import java.io.Serializable;

public class Classroom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4119564346868032649L;
	private int roomNumber;
	private RoomBuilding roomBuilding;
	private int capacity;
	private ProjectorOrNot projectorOrNot;

	public Classroom(int roomNumber, RoomBuilding roomBuilding, int capacity, ProjectorOrNot projectorOrNot) {
		super();
		this.roomNumber = roomNumber;
		this.roomBuilding = roomBuilding;
		this.capacity = capacity;
		this.projectorOrNot = projectorOrNot;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomBuilding getRoomBuilding() {
		return roomBuilding;
	}

	public void setRoomBuilding(RoomBuilding roomBuilding) {
		this.roomBuilding = roomBuilding;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ProjectorOrNot getProjectorOrNot() {
		return projectorOrNot;
	}

	public void setProjectorOrNot(ProjectorOrNot projectorOrNot) {
		this.projectorOrNot = projectorOrNot;
	}

	@Override
	public String toString() {
		return "Classroom [roomNumber=" + roomNumber + ", roomBuilding=" + roomBuilding + ", capacity=" + capacity
				+ ", projectorOrNot=" + projectorOrNot + "]";
	}

}
