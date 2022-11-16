package com.rdasystems.audiomanager.utility;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LocalResponse<T> {
    private List<T> litsOfItems;
    private int totalPages;
    private int numberOfElement;
    private int currentPage;


}
