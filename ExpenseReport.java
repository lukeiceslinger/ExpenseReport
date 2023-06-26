package com.vikasietum.interviews.expense;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    ExpenseType type;
    int amount;
}

class ExpensePrinter {
    public void printExpenses(List<Expense> expenses) {
        // Create an instance of ExpenseReport
        ExpenseReport report = new ExpenseReport();
        // Call the printReport method to print the expenses
        report.printReport(expenses);
    }
}

class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        // Calculate total expenses and meal expenses
        int total = calculateTotalExpenses(expenses);
        int mealExpenses = calculateMealExpenses(expenses);

        // Print the report header with the current date
        System.out.println("Expenses " + new Date());

        // Iterate over the expenses and print each expense
        for (Expense expense : expenses) {
            printExpense(expense);
        }

        // Print the meal expenses and total expenses
        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

    private void printExpense(Expense expense) {
        // Check if the expense is a meal expense and print accordingly
        if (isMealExpense(expense)) {
            System.out.println(getExpenseName(expense.type) + "\t" + expense.amount + "\tX");
        } else {
            System.out.println(getExpenseName(expense.type) + "\t" + expense.amount + "\t ");
        }
    }

    private boolean isMealExpense(Expense expense) {
        // Check if the expense is a dinner expense (amount > 5000) or a breakfast expense (amount > 1000)
        return (expense.type == ExpenseType.DINNER && expense.amount > 5000) ||
                (expense.type == ExpenseType.BREAKFAST && expense.amount > 1000);
    }

    private int calculateTotalExpenses(List<Expense> expenses) {
        int total = 0;
        // Iterate over the expenses and calculate the total amount
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        return total;
    }

    private int calculateMealExpenses(List<Expense> expenses) {
        int mealExpenses = 0;
        // Iterate over the expenses and calculate the total meal expenses
        for (Expense expense : expenses) {
            if (isMealExpense(expense)) {
                mealExpenses += expense.amount;
            }
        }
        return mealExpenses;
    }

    private String getExpenseName(ExpenseType type) {
        // Get the name corresponding to an ExpenseType
        switch (type) {
            case DINNER:
                return "Dinner";
            case BREAKFAST:
                return "Breakfast";
            case CAR_RENTAL:
                return "Car Rental";
            default:
                return "";
        }
    }
}
