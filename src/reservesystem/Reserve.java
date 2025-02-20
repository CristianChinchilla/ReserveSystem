/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservesystem;

/**
 *
 * @author cchin
 */
class Reserve {

    private String date;

    private String user;

    private String id;

    private String startTime;

    private String endTime;
    
    private String reserveNumber;

    private String status;
    
    public Reserve(String date, String user, String id, String startTime, String endTime, String reserveNumber) {
        this.date = date;
        this.user = user;
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserveNumber = reserveNumber;
    }
    /**
     * Return the date of the reserve
     * @return date
     */
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getReserveNumber() {
        return reserveNumber;
    }
    
    public void setReserveNumber(String reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

}
