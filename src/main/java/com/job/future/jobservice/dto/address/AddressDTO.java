package com.job.future.jobservice.dto.address;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AddressDTO {
    private String name;
    private int code;
    private String divisionType;
    private int phoneCode;
    private String codename;
    private List<DistrictDTO> districts;

    // Các getter và setter của các thuộc tính

    public static class DistrictDTO {
        private String name;
        private int code;
        private String codename;
        private String divisionType;
        private int provinceCode;
        private List<WardDTO> wards;

        // Các getter và setter của các thuộc tính

        public static class WardDTO {
            private String name;
            private int code;
            private String codename;
            private String divisionType;
            private int provinceCode;

            // Các getter và setter của các thuộc tính
        }
    }
}