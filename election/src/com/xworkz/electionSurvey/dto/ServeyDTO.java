package com.xworkz.electionSurvey.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class ServeyDTO implements Serializable, Comparable<String> {

    public  ServeyDTO(){

    }
    private String name;
    private String occupation;
    private String education;
    private String nativePlace;
    private String bikeNumber;
    private String carNumber;
    private long mobileNumber;
    private long aadharNumber;
    private String panCardNumber;
    private long voterIDNumber;



    @Override
    public String toString() {
        return "ServeyDTO{" +
                "name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", education='" + education + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", bikeNumber='" + bikeNumber + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", aadharNumber=" + aadharNumber +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", voterIDNumber=" + voterIDNumber +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name, occupation, education, nativePlace, bikeNumber, carNumber, mobileNumber, aadharNumber,
                panCardNumber, voterIDNumber
        );
    }

    @Override
    public int compareTo(String o) {
        return this.name.compareTo(o);
    }
}
