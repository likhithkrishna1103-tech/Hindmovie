package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements n, Iterable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f3145u;

    public p(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.f3145u = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean b() {
        return Boolean.valueOf(!this.f3145u.isEmpty());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.f3145u.equals(((p) obj).f3145u);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator f() {
        return new r(1, this);
    }

    public final int hashCode() {
        return this.f3145u.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return this.f3145u;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new r(0, this);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new p(this.f3145u);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.n
    public final n l(String str, ub.o oVar, ArrayList arrayList) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String strI;
        int i;
        int i10;
        int i11;
        ub.o oVar2;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || "search".equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str) || "toLocaleUpperCase".equals(str)) {
            str2 = "hasOwnProperty";
            str3 = "trim";
        } else {
            str2 = "hasOwnProperty";
            str3 = "trim";
            if (!str3.equals(str)) {
                throw new IllegalArgumentException(str.concat(" is not a String function"));
            }
        }
        byte b10 = -1;
        switch (str.hashCode()) {
            case -1789698943:
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                if (str.equals(str4)) {
                    b10 = 0;
                }
                break;
            case -1776922004:
                str5 = "charAt";
                str6 = "toString";
                str4 = str2;
                if (str.equals(str6)) {
                    b10 = 1;
                }
                break;
            case -1464939364:
                str5 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    str4 = str2;
                    str6 = "toString";
                    b10 = 2;
                }
                str4 = str2;
                str6 = "toString";
                break;
            case -1361633751:
                str5 = "charAt";
                if (str.equals(str5)) {
                    str4 = str2;
                    str6 = "toString";
                    b10 = 3;
                }
                str4 = str2;
                str6 = "toString";
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    b10 = 4;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    b10 = 5;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case -906336856:
                if (str.equals("search")) {
                    b10 = 6;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    b10 = 7;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b10 = 8;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    b10 = 9;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 3568674:
                if (str.equals(str3)) {
                    b10 = 10;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 103668165:
                if (str.equals("match")) {
                    b10 = 11;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b10 = 12;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 109648666:
                if (str.equals("split")) {
                    b10 = 13;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 530542161:
                if (str.equals("substring")) {
                    b10 = 14;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    b10 = 15;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b10 = 16;
                }
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
            default:
                str4 = str2;
                str5 = "charAt";
                str6 = "toString";
                break;
        }
        strI = "undefined";
        String str7 = str4;
        String str8 = this.f3145u;
        switch (b10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c4.i(str7, 1, arrayList);
                n nVarL0 = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0));
                if (!"length".equals(nVarL0.i())) {
                    double dDoubleValue = nVarL0.n().doubleValue();
                    if (dDoubleValue != Math.floor(dDoubleValue) || (i = (int) dDoubleValue) < 0 || i >= str8.length()) {
                        return n.f3111g;
                    }
                }
                return n.f;
            case 1:
                c4.i(str6, 0, arrayList);
                return this;
            case 2:
                c4.i("toLocaleLowerCase", 0, arrayList);
                return new p(str8.toLowerCase());
            case 3:
                c4.q(str5, 1, arrayList);
                int iA = !arrayList.isEmpty() ? (int) c4.a(((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).n().doubleValue()) : 0;
                return (iA < 0 || iA >= str8.length()) ? n.f3112h : new p(String.valueOf(str8.charAt(iA)));
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                if (!arrayList.isEmpty()) {
                    StringBuilder sb2 = new StringBuilder(str8);
                    for (int i12 = 0; i12 < arrayList.size(); i12++) {
                        sb2.append(((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(i12)).i());
                    }
                    return new p(sb2.toString());
                }
                return this;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                c4.i("toLowerCase", 0, arrayList);
                return new p(str8.toLowerCase(Locale.ENGLISH));
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                c4.q("search", 1, arrayList);
                return Pattern.compile(arrayList.isEmpty() ? "undefined" : ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i()).matcher(str8).find() ? new g(Double.valueOf(r0.start())) : new g(Double.valueOf(-1.0d));
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                c4.i("toLocaleUpperCase", 0, arrayList);
                return new p(str8.toUpperCase());
            case 8:
                c4.q("lastIndexOf", 2, arrayList);
                strI = arrayList.size() > 0 ? ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i() : "undefined";
                return new g(Double.valueOf(str8.lastIndexOf(strI, (int) (Double.isNaN(arrayList.size() < 2 ? Double.NaN : ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1)).n().doubleValue()) ? Double.POSITIVE_INFINITY : c4.a(r2)))));
            case 9:
                c4.i("toUpperCase", 0, arrayList);
                return new p(str8.toUpperCase(Locale.ENGLISH));
            case 10:
                c4.i("toUpperCase", 0, arrayList);
                return new p(str8.trim());
            case 11:
                c4.q("match", 1, arrayList);
                Matcher matcher = Pattern.compile(arrayList.size() <= 0 ? "" : ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i()).matcher(str8);
                return matcher.find() ? new e(new p(matcher.group())) : n.f3107b;
            case 12:
                c4.q("slice", 2, arrayList);
                double dA = c4.a(!arrayList.isEmpty() ? ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).n().doubleValue() : 0.0d);
                int iMax = (int) (dA < 0.0d ? Math.max(((double) str8.length()) + dA, 0.0d) : Math.min(dA, str8.length()));
                double dA2 = c4.a(arrayList.size() > 1 ? ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1)).n().doubleValue() : str8.length());
                return new p(str8.substring(iMax, Math.max(0, ((int) (dA2 < 0.0d ? Math.max(((double) str8.length()) + dA2, 0.0d) : Math.min(dA2, str8.length()))) - iMax) + iMax));
            case 13:
                c4.q("split", 2, arrayList);
                if (str8.length() == 0) {
                    return new e(this);
                }
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.isEmpty()) {
                    arrayList2.add(this);
                } else {
                    String strI2 = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i();
                    long jM = arrayList.size() > 1 ? ((long) c4.m(((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1)).n().doubleValue())) & 4294967295L : 2147483647L;
                    if (jM == 0) {
                        return new e();
                    }
                    String[] strArrSplit = str8.split(Pattern.quote(strI2), ((int) jM) + 1);
                    int length = strArrSplit.length;
                    if (!strI2.isEmpty() || strArrSplit.length <= 0) {
                        i10 = 0;
                    } else {
                        boolean zIsEmpty = strArrSplit[0].isEmpty();
                        i10 = zIsEmpty;
                        if (strArrSplit[strArrSplit.length - 1].isEmpty()) {
                            length = strArrSplit.length - 1;
                            i10 = zIsEmpty;
                        }
                    }
                    if (strArrSplit.length > jM) {
                        length--;
                    }
                    while (i10 < length) {
                        arrayList2.add(new p(strArrSplit[i10]));
                        i10++;
                    }
                }
                return new e(arrayList2);
            case 14:
                c4.q("substring", 2, arrayList);
                int iA2 = !arrayList.isEmpty() ? (int) c4.a(((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).n().doubleValue()) : 0;
                int iA3 = arrayList.size() > 1 ? (int) c4.a(((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1)).n().doubleValue()) : str8.length();
                int iMin = Math.min(Math.max(iA2, 0), str8.length());
                int iMin2 = Math.min(Math.max(iA3, 0), str8.length());
                return new p(str8.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
            case 15:
                c4.q("replace", 2, arrayList);
                boolean zIsEmpty2 = arrayList.isEmpty();
                n nVarA = n.f3106a;
                if (!zIsEmpty2) {
                    strI = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i();
                    if (arrayList.size() > 1) {
                        nVarA = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1));
                    }
                }
                int iIndexOf = str8.indexOf(strI);
                if (iIndexOf >= 0) {
                    if (nVarA instanceof j) {
                        i11 = 0;
                        nVarA = ((j) nVarA).a(oVar, Arrays.asList(new p(strI), new g(Double.valueOf(iIndexOf)), this));
                    } else {
                        i11 = 0;
                    }
                    return new p(str8.substring(i11, iIndexOf) + nVarA.i() + str8.substring(strI.length() + iIndexOf));
                }
                return this;
            case 16:
                c4.q("indexOf", 2, arrayList);
                if (arrayList.size() <= 0) {
                    oVar2 = oVar;
                } else {
                    oVar2 = oVar;
                    strI = ((h4.z) oVar2.f12869w).l0(oVar2, (n) arrayList.get(0)).i();
                }
                return new g(Double.valueOf(str8.indexOf(strI, (int) c4.a(arrayList.size() < 2 ? 0.0d : ((h4.z) oVar2.f12869w).l0(oVar2, (n) arrayList.get(1)).n().doubleValue()))));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double n() {
        String str = this.f3145u;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String toString() {
        return e6.j.n("\"", this.f3145u, "\"");
    }
}
