/**
 *    Copyright 2017 Yunxiang He
 *
 *    All right reserved.
 * 
 *    Create on Nov 11, 2017 4:37:01 AM
 */
package homework.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Yunxiang He
 * @date Nov 11, 2017 4:37:01 AM
 */
public class homework {

    private ArrayList<Predicate> queries = new ArrayList<>();
    private ArrayList<Clause> kb = new ArrayList<>();

    private void init() {
        int flag = 0;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("input.txt"));
            String s = null;
            while ((s = bf.readLine()) != null) {
                if (Pattern.matches("^\\d+$", s)) {
                    flag++;
                    continue;
                }
                if (flag == 1) {
                    queries.add(new Predicate(getPredicateName(s), getParams(s), getNeg(s)));
                }
                if (flag == 2) {
                    ArrayList<Predicate> clist = new ArrayList<>();
                    s = s.replaceAll(" ", "");
                    for (String str : s.split("\\|")) {
                        clist.add(new Predicate(getPredicateName(str), getParams(str), getNeg(str)));
                    }
                    kb.add(new Clause(clist));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
                if (bf != null)
                    bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean ask(Predicate initialQuery) {

        // 对query取反
        initialQuery.setNeg(!initialQuery.isNeg());

        ArrayList<Clause> visited = new ArrayList<>();

        // 每次query, 都要克隆一份kb
        ArrayList<Clause> _kb = new ArrayList<>();
        for (Clause clause : kb) {
            _kb.add(clause.clone());
        }

        // 把 quuery 的 predicate 转成clause
        ArrayList<Predicate> list = new ArrayList<>();
        list.add(initialQuery);
        Clause initialClause = new Clause(list);

        visited.add(initialClause);
        _kb.add(initialClause);

        boolean res = resolution(initialClause, _kb, visited);

        flag = false;
        return res;

    }

    private boolean flag = false;

    private boolean resolution(Clause query, ArrayList<Clause> kb, ArrayList<Clause> visited) {

        boolean isContinue = true;
        outter: while (isContinue) {
            isContinue = false;
            for (int i = 0; i < kb.size(); i++) {
                Clause c1 = kb.get(i);
                for (int j = i; j < kb.size(); j++) {
                    Clause c2 = kb.get(j);
                    Clause newClause = resolve(c1.clone(), c2.clone());
                    if (newClause != null) {
                        System.out.println(newClause);
                        if (newClause.getPredicateList().size() == 0) {
                            flag = true;
                            break outter;
                        } else {
                            if (shouldContain(kb, newClause)) {
                                isContinue = true;
                                kb.add(newClause);
                            }
                        }
                    }

                }
            }
            if (isContinue) {
                continue;
            }
        }
        return flag;
    }

    private boolean shouldContain(ArrayList<Clause> clauses, Clause newClause) {
        boolean shouldContain = false;
        if (!clauses.contains(newClause)) {
            kb_Clause: for (Clause kb_clause : clauses) {
                kb_Clause_Predicate: for (Predicate kb_predicate : kb_clause.getPredicateList()) {
                    if (newClause.getPredicateList().contains(kb_predicate)) {
                        continue kb_Clause_Predicate;
                    } else {
                        continue kb_Clause;
                    }
                }
                shouldContain = false;
                return shouldContain;
            }
            shouldContain = true;
        }

        return shouldContain;
    }

    public Clause resolve(Clause c1, Clause c2) {
        boolean isR = false;

        // 待resolve的predicate list
        ArrayList<Predicate> c1PredicateList = c1.getPredicateList();
        // kb当前clause的predicate list
        ArrayList<Predicate> c2PredicateList = c2.getPredicateList();

        // c1的每个predicate
        Predicate: for (int i = 0; i < c1PredicateList.size(); i++) {
            // c1 predicate
            Predicate c1Predicate = c1PredicateList.get(i);
            String c1Predicate_name = c1Predicate.getName();
            boolean c1Predicate_neg = c1Predicate.isNeg();
            ArrayList<String> c1Predicate_params = c1Predicate.getParams();

            // c2的每个predicate
            for (int j = 0; j < c2PredicateList.size(); j++) {

                // 这两个predicate 是否可以resolve
                boolean isResolvable = true;

                // c2 predicate
                Predicate c2Predicate = c2PredicateList.get(j);
                String c2Predicate_name = c2Predicate.getName();
                boolean c2Predicate_neg = c2Predicate.isNeg();
                ArrayList<String> c2Predicate_params = c2Predicate.getParams();

                // 如果两个predicate的名称相同
                if (c1Predicate_name.equals(c2Predicate_name)) {

                    // 如果两个predicate的符号相反
                    if (c1Predicate_neg != c2Predicate_neg) {

                        // 检查predicate的参数列表
                        PredicateArg: for (int n = 0; n < c1Predicate_params.size(); n++) {

                            String c1Param = c1Predicate_params.get(n);
                            String c2Param = c2Predicate_params.get(n);

                            // 如果都是常量, 则判断常量是否相等
                            if (Character.isUpperCase(c1Param.charAt(0)) && Character.isUpperCase(c2Param.charAt(0))) {

                                // 相等则检查下一个参数
                                if (c1Param.equals(c2Param)) {
                                    continue;
                                } else {
                                    isResolvable = false;
                                    break PredicateArg;
                                }
                            }

                            // c1 常量, c2 变量
                            else if (Character.isUpperCase(c1Param.charAt(0)) && Character.isLowerCase(c2Param.charAt(0))) {

                                // 替换c2里的同名变量
                                for (Predicate _c2Predicate : c2PredicateList) {
                                    for (int a = 0; a < _c2Predicate.getParams().size(); a++) {
                                        if (_c2Predicate.getParams().get(a).equals(c2Param)) {
                                            _c2Predicate.getParams().set(a, c1Param);
                                        }
                                    }
                                }
                            }

                            // c2 常量, c1 变量
                            else if (Character.isLowerCase(c1Param.charAt(0)) && Character.isUpperCase(c2Param.charAt(0))) {

                                // 替换c1里的同名变量
                                for (Predicate _c1Predicate : c1PredicateList) {
                                    for (int a = 0; a < _c1Predicate.getParams().size(); a++) {
                                        if (_c1Predicate.getParams().get(a).equals(c1Param)) {
                                            _c1Predicate.getParams().set(a, c2Param);
                                        }
                                    }
                                }
                            }

                            if (Character.isLowerCase(c1Param.charAt(0)) && Character.isLowerCase(c2Param.charAt(0))) {
                                isResolvable = false;
                                break PredicateArg;
                            }
                        }
                        if (isResolvable) {
                            isR = true;
                            if (c1PredicateList.size() > 0 && c2PredicateList.size() > 0) {
                                c1PredicateList.remove(i);
                                c2PredicateList.remove(j);
                            }
                            break Predicate;
                        }
                    }
                }
            }
        }

        if (isR) {
            ArrayList<Predicate> newClause = new ArrayList<>();
            for (Predicate predicate : c1PredicateList) {
                if (predicate != null && !newClause.contains(predicate))
                    newClause.add(predicate);
            }

            for (Predicate predicate : c2PredicateList) {
                if (predicate != null && !newClause.contains(predicate))
                    newClause.add(predicate);
            }

            Clause clause = new Clause(newClause);
            return clause;
        } else
            return null;

    }

    private String getPredicateName(String s) {
        return s.substring(s.indexOf("~") + 1, s.indexOf("("));
    }

    private ArrayList<String> getParams(String s) {
        String _s = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
        List<String> sL = Arrays.asList(_s.split(","));
        ArrayList<String> list = new ArrayList<>(sL);
        return list;
    }

    private boolean getNeg(String s) {
        return s.contains("~");
    }

    public ArrayList<Predicate> getQueries() {
        return queries;
    }

    public void setQueries(ArrayList<Predicate> queries) {
        this.queries = queries;
    }

    public ArrayList<Clause> getKb() {
        return kb;
    }

    public void setKb(ArrayList<Clause> kb) {
        this.kb = kb;
    }

    public static void main(String[] args) {

        homework hw = new homework();
        hw.init();
        ArrayList<Predicate> queries = hw.getQueries();
        ArrayList<Boolean> res = new ArrayList<>();

        for (Predicate predicate : queries) {
            res.add(hw.ask(predicate));
        }
        hw.output(res);

    }

    private void output(ArrayList<Boolean> res) {
        BufferedWriter bw = null;
        try {
            File file = new File("output.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            for (boolean b : res) {
                if (b) {
                    System.out.println("TRUE");
                    bw.write("TRUE");
                } else {
                    System.out.println("FALSE");
                    bw.write("FALSE");
                }
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Clause {
    @Override
    public boolean equals(Object obj) {

        Clause c1 = this.clone();
        Clause c2 = ((Clause) obj).clone();
        // 如果两个clause长度相同
        if (c1.predicateList.size() == c2.predicateList.size()) {
            // 如果还有还有predicate没有消掉
            whileloop: while (c1.predicateList.size() > 0) {
                for (int i = 0; i < c1.predicateList.size(); i++) {
                    Predicate p1 = c1.predicateList.get(i);
                    for (int j = 0; j < c2.predicateList.size();) {
                        Predicate p2 = c2.predicateList.get(j);
                        // 如果名称和符号都相同
                        if (p1.getName().equals(p2.getName()) && p1.isNeg() == p2.isNeg()) {
                            // 遍历参数列表
                            for (int n = 0; n < p1.getParams().size(); n++) {
                                String param1 = p1.getParams().get(n);
                                String param2 = p2.getParams().get(n);

                                // 如果两个参数的字面量相同
                                if (param1.equals(param2)) {
                                    continue;
                                }
                                // 如果两个参数的字面量不相同
                                else {
                                    if (param1.contains("0") || param2.contains("0")) {
                                        if (!param1.equals(param2)) {
                                            break;
                                        }
                                    }
                                    // 如果两个predicate的第n个参数都是变量
                                    else if (Character.isLowerCase(param1.charAt(0)) && Character.isLowerCase(param2.charAt(0))) {
                                        if (param1.equals(param2)) {
                                            continue;
                                        } else {
                                            // 同名所有参数
                                            for (Predicate _c1Predicate : c1.predicateList) {
                                                for (int a = 0; a < _c1Predicate.getParams().size(); a++) {
                                                    if (_c1Predicate.getParams().get(a).equals(param1)) {
                                                        _c1Predicate.getParams().set(a, "hyx" + "0" + i + j + n);
                                                    }
                                                }
                                            }

                                            for (Predicate _c2Predicate : c2.predicateList) {
                                                for (int a = 0; a < _c2Predicate.getParams().size(); a++) {
                                                    if (_c2Predicate.getParams().get(a).equals(param2)) {
                                                        _c2Predicate.getParams().set(a, "hyx" + "0" + i + j + n);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    // 如果两个predicate的第n个参数都是常量,或者一个常量一个变量
                                    else
                                        break;
                                }
                            }
                        }
                        if (!p1.equals(p2)) {
                            break;
                        } else {
                            c1.predicateList.remove(i);
                            c2.predicateList.remove(j);
                            continue whileloop;
                        }
                    }
                }
                return false;
            }
            if (c1.predicateList.size() == 0 && c2.predicateList.size() == 0) {
                return true;
            } else
                return false;
            // return true;
        }
        // 如果两个clause的长度不相同
        else {
            return false;
        }
    }

    ArrayList<Predicate> predicateList = new ArrayList<>();

    public Clause(ArrayList<Predicate> predicateList) {
        super();
        this.predicateList = predicateList;
    }

    public ArrayList<Predicate> getPredicateList() {
        return predicateList;
    }

    public void setPredicateList(ArrayList<Predicate> predicateList) {
        this.predicateList = predicateList;
    }

    @Override
    protected Clause clone() {
        ArrayList<Predicate> list = new ArrayList<>();
        for (Predicate p : this.predicateList) {
            list.add(p.clone());
        }
        return new Clause(list);
    }

    @Override
    public String toString() {
        String reString = "";
        for (Predicate predicate : predicateList) {
            reString += predicate.toString() + "| ";
        }
        return reString.length() == 0 ? "" : reString.substring(0, reString.lastIndexOf("| "));
    }
}

class Predicate {
    private String name;
    private ArrayList<String> params;
    private boolean neg;

    public Predicate(String name, ArrayList<String> ArrayList, boolean neg) {
        super();
        this.name = name;
        this.params = ArrayList;
        this.neg = neg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public boolean isNeg() {
        return neg;
    }

    public void setNeg(boolean neg) {
        this.neg = neg;
    }

    @Override
    protected Predicate clone() {
        ArrayList<String> params = new ArrayList<>();
        for (String string : this.params) {
            params.add(string);
        }
        Predicate predicate = new Predicate(this.name, params, this.neg);
        return predicate;
    }

    @Override
    public boolean equals(Object _obj) {
        Predicate p1 = this.clone();
        Predicate p2 = ((Predicate) _obj).clone();
        // 名称符号都相同
        if (p1.name.equals(p2.getName()) && p1.neg == p2.isNeg()) {
            // 判断参数列表
            for (int i = 0; i < this.params.size(); i++) {
                // 如果都是常量
                if (Character.isUpperCase(p1.params.get(i).charAt(0)) && Character.isUpperCase(p2.params.get(i).charAt(0))) {
                    if (!p1.params.get(i).equals(p2.params.get(i)))
                        return false;
                } else if (Character.isLowerCase(p1.params.get(i).charAt(0)) && Character.isUpperCase(p2.params.get(i).charAt(0))) {
                    return false;
                } else if (Character.isUpperCase(p1.params.get(i).charAt(0)) && Character.isLowerCase(p2.params.get(i).charAt(0))) {
                    return false;
                } else {
                    String variable1 = p1.params.get(i);
                    String variable2 = p2.params.get(i);
                    if (variable1.contains("0")) {
                        if (!variable1.equals(variable2)) {
                            return false;
                        }
                    } else {
                        String sub = variable1 + "0" + i;
                        for (int n = 0; n < p1.params.size(); n++) {
                            if (p1.params.get(n).equals(variable1))
                                p1.params.set(n, sub);
                            if (p2.params.get(n).equals(variable2))
                                p2.params.set(n, sub);
                        }
                    }
                }
            }
            for (int n = 0; n < p1.params.size(); n++) {
                if (!p1.params.get(n).equals(p2.params.get(n)))
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reString = "";
        if (neg) {
            reString += "~";
        }
        reString += name;
        reString += "(";
        for (String string : params) {
            reString += string + ", ";
        }
        reString = reString.substring(0, reString.lastIndexOf(", "));
        reString += ") ";
        return reString;
    }

}
