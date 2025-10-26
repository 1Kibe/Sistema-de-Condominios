package com.ryan.condominosys.repository.query;

import java.util.List;

import com.ryan.condominosys.domain.Andar;
import com.ryan.condominosys.repository.filter.AndarRepositoryFilter;

public interface AndarRepositoryQuery {

    public List<Andar> pg (AndarRepositoryFilter filtro);
}
