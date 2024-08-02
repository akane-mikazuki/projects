package com.example.cust.customer_data;

import javax.persistence.Convert;

import com.example.cust.AccountTypeConverter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    
    @Convert(converter = AccountTypeConverter.class)
    private AccountType accountType;

    public enum AccountType {
        S("SAVINGS"),
        C("CHECKING");

        private final String code;

        AccountType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static AccountType fromCode(String code) {
            for (AccountType type : AccountType.values()) {
                if (type.getCode().equals(code)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Unknown code: " + code);
        }
    }
}
