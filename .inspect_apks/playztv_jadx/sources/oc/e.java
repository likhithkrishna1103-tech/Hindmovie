package oc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9530e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9532h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f9534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f9535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f9536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f9537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9539p;

    public static List b(ArrayList arrayList) {
        if (arrayList.size() < 2) {
            return arrayList;
        }
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            e eVar = (e) arrayList.get(i);
            if (eVar.f9538o == 1 && !eVar.f9539p) {
                map.put(Integer.valueOf(i), eVar);
            } else if (eVar.f9539p) {
                arrayList3.add(eVar);
            } else {
                arrayList2.add(eVar);
            }
        }
        Collections.sort(arrayList2, new c4.d(7));
        Collections.sort(arrayList3, new c4.d(8));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        ArrayList arrayList5 = new ArrayList(arrayList.size());
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (map.containsKey(Integer.valueOf(i11))) {
                arrayList5.add((e) map.get(Integer.valueOf(i11)));
            } else {
                arrayList5.add((e) arrayList4.get(i10));
                i10++;
            }
        }
        return arrayList5;
    }

    public final Date a() {
        try {
            return new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss").parse(this.f9533j + "|" + this.i);
        } catch (ParseException unused) {
            return null;
        }
    }
}
