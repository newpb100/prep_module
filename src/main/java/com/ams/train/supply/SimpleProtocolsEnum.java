package com.ams.train.supply;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SimpleProtocolsEnum implements EnumDescriptive{
    DHCP("Dynamic Host Configuration Protocol", "Dynamically assigns an IP address"),
    NFS("Network File System", "Distributed file system protocol"),
    HTTP("Hypertext Transfer Protocol", false);

    private String fullName;
    private String descriptive;
    public String pubField;

    @Getter
    private boolean secure = true;

    SimpleProtocolsEnum(String fullName, String descriptive) {
        this.fullName = fullName;
        this.descriptive = descriptive;
    }

    SimpleProtocolsEnum(String fullName, boolean secure) {
        this.secure = secure;
    }

    @Override
    public String getDescription() {
        return descriptive;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    // вместо этого метода использовал аннотацию ломбок на самом поле
/*    public boolean isSecure() {
        return secure;
    }*/


    //  обрати внимание, тут статическим методом достается переменная (secure) из нестатического контекста - и это работает
    //
    public static List<SimpleProtocolsEnum> getSecureProtocols() {

        //return Arrays.asList(values()).stream().filter(SimpleProtocolsEnum::isSecure).collect(Collectors.toList());

        // предлагается замена на :
        //return Arrays.stream(values()).filter(SimpleProtocolsEnum::isSecure).collect(Collectors.toList());

        // почему в одних методах стримового апи надо прописывать вызовы методов через "::", а в других через "." (Collectors.toList())	?

        // кстати, вот такой вариант тоже сработал!
        return Stream.of(values()).filter(SimpleProtocolsEnum::isSecure).collect(Collectors.toList());

        // а вот если напрямую попробовать обратиться к isSecure()
        // err: Non-static method isSecure() cannot be referenced from a static context
        // System.out.println(SimpleProtocolsEnum.isSecure());
    }

    @Override
    public String toString(){
        return "Proto: " + getFullName() + " ; Desc: " + getFullName() + " ; secure?: " + secure;
    }
}
