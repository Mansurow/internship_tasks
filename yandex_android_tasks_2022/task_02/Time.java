package yandextask.com;

public class Time {
    byte hours;
    byte minutes;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
    }

    public Time (String timeData){
        String [] splitTimeData = timeData.split(":");
        this.hours = Byte.parseByte(splitTimeData[0]);
        this.minutes = Byte.parseByte(splitTimeData[1]);
    }

    public Time(byte hours, byte minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public byte getHours() {
        return hours;
    }

    public void setHours(byte hours) {
        this.hours = hours;
    }

    public byte getMinutes() {
        return minutes;
    }

    public void setMinutes(byte minutes) {
        this.minutes = minutes;
    }

    public Time findDifferents(Time endTime, byte timeZone) {
        Time resultTime = new Time();

        byte startHours = this.getHours();
        byte startMinutes = this.getMinutes();
        byte endHours = endTime.getHours();
        byte endMinutes = endTime.getMinutes();
        byte resultHours = 0;

        if (startHours > endHours)
            resultHours = (byte) (24 - startHours + endHours + timeZone);
        else
            resultHours = (byte) (endHours - startHours + timeZone);

        if (resultHours < 0)
            resultHours = (byte) -resultHours;

        if (startMinutes <= endMinutes)
            resultTime.setMinutes((byte) (endMinutes - startMinutes));
        else {
            resultHours--;
            resultTime.setMinutes((byte) (endMinutes + 60 - startMinutes));
        }
        resultTime.setHours(resultHours);

        return resultTime;
    }

    public void printTime() {
        if (this.minutes < 10)
            System.out.printf("%d:0%d", this.hours, this.minutes);
        else
            System.out.printf("%d:%d", this.hours, this.minutes);
    }
}
