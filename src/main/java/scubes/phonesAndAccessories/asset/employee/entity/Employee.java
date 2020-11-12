package scubes.phonesAndAccessories.asset.employee.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import scubes.phonesAndAccessories.asset.commonAsset.model.Enum.CivilStatus;
import scubes.phonesAndAccessories.asset.commonAsset.model.Enum.Gender;
import scubes.phonesAndAccessories.asset.commonAsset.model.Enum.Title;
import scubes.phonesAndAccessories.asset.commonAsset.model.FileInfo;
import scubes.phonesAndAccessories.asset.employee.entity.enums.Designation;
import scubes.phonesAndAccessories.asset.employee.entity.enums.EmployeeStatus;
import scubes.phonesAndAccessories.util.audit.AuditEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Employee" )
public class Employee extends AuditEntity {

    @Column(unique = true)
    private String code;

    @Size( min = 5, message = "Your name cannot be accepted" )
    private String name;

    @Size( min = 5, message = "At least 5 characters should be included calling name" )
    private String callingName;

    @Size( max = 12, min = 10, message = "NIC number is contained numbers between 9 and X/V or 12 " )
    @Column( unique = true )
    private String nic;

    @Size( max = 10, message = "Mobile number length should be contained 10 and 9" )
    private String mobileOne;

    @Size( max = 10, message = "Mobile number length should be contained 10 and 9" )
    private String mobileTwo;

    @Size( max = 10, message = "Phone number length should be contained 10 and 9" )
    private String land;

    @Column( unique = true )
    private String officeEmail;

    @Column( columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL", length = 255 )
    private String address;

    @Enumerated( EnumType.STRING )
    private Title title;

    @Enumerated( EnumType.STRING )
    private Gender gender;

    @Enumerated( EnumType.STRING )
    private Designation designation;

    @Enumerated( EnumType.STRING )
    private CivilStatus civilStatus;

    @Enumerated( EnumType.STRING )
    private EmployeeStatus employeeStatus;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private LocalDate dateOfBirth;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private LocalDate dateOfAssignment;

    @Transient
    private MultipartFile file;


    @Transient
    private FileInfo fileInfo;

}
