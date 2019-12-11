package com.ming.eurekaclient.controller;

import com.ming.eurekaclient.serivce.IFactorySerivce;
import com.ming.eurekaclient.serivce.IOneStepStatckService;
import com.ming.eurekaclient.serivce.ISortService;
import com.ming.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panyanming on 2019/10/29.
 */
@RequestMapping(value = "factory")
@Controller
public class FactoryController {

    @Autowired
    IFactorySerivce factorySerivce;

    @RequestMapping(value = "testFactory.do")
    @ResponseBody
    public void testFactoryBean(HttpServletRequest request) {
        factorySerivce.excecute(1);
    }


    @RequestMapping(value = "testModel.do")
    @ResponseBody
    public void testModel(HttpServletRequest request) {
        Book book = new Book();
        book.setName("book1");
        book.setPrice(0.01);
    }

    @Autowired
    ISortService sortService;

    @RequestMapping(value = "testSort.do")
    @ResponseBody
    public void testSort() {
        sortService.execute(EnumSortType.MergeSort.getValue());
        sortService.execute(EnumSortType.QuickSort.getValue());
        sortService.execute(EnumSortType.InsertSort.getValue());
        sortService.execute(EnumSortType.SelectionSort.getValue());
        sortService.execute(EnumSortType.HeapSort.getValue());
    }


    @Autowired
    IOneStepStatckService oneStepStatckService;

    @RequestMapping(value = "oneStack.do")
    @ResponseBody
    public void oneStack() {
        int[] arr = {3, 4, 6, 7, 2, 1};
        int[][] execute = oneStepStatckService.execute(1, arr);
        for (int i = 0; i < execute.length; i++) {
            System.out.println("{" + execute[i][0] + "," + execute[i][1] + "}");
        }
    }


    private enum EnumSortType {
        MergeSort(1), QuickSort(2), InsertSort(3), SelectionSort(4), HeapSort(5);
        private int value;

        EnumSortType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
