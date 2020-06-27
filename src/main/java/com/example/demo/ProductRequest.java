package com.example.demo;

import java.util.List;

public class ProductRequest
{
    private String requestID;
    private List<String> tagNumber;
    private String customerID;
    public String getRequestID()
    {
        return requestID;
    }

    public void setRequestID(String requestID)
    {
        this.requestID = requestID;
    }

    public List<String> getTagNumber()
    {
        return tagNumber;
    }

    public void setTagNumber(List<String> tagNumber)
    {
        this.tagNumber = tagNumber;
    }

    public String getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }

    public ProductRequest()
    {
        super();
       
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
        result = prime * result + ((requestID == null) ? 0 : requestID.hashCode());
        result = prime * result + ((tagNumber == null) ? 0 : tagNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductRequest other = (ProductRequest)obj;
        if (customerID == null)
        {
            if (other.customerID != null)
                return false;
        }
        else if (!customerID.equals(other.customerID))
            return false;
        if (requestID == null)
        {
            if (other.requestID != null)
                return false;
        }
        else if (!requestID.equals(other.requestID))
            return false;
        if (tagNumber == null)
        {
            if (other.tagNumber != null)
                return false;
        }
        else if (!tagNumber.equals(other.tagNumber))
            return false;
        return true;
    }
    

}
