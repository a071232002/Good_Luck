package com.mem.model;

import javax.validation.groups.Default;

//讓除了註冊會員以外的功能忽略@UniqueMemMail、@UniqueMemPhone、@UniqueMemID
public interface Create extends Default{

}
