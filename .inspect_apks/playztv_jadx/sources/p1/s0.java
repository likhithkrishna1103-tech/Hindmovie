package p1;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0 f10056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10057c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f10058a;

    static {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        s1.d.g(!false);
        f10056b = new s0(new o(sparseBooleanArray));
        int i = s1.b0.f11647a;
        f10057c = Integer.toString(0, 36);
    }

    public s0(o oVar) {
        this.f10058a = oVar;
    }

    public final boolean a(int i) {
        return this.f10058a.f9953a.get(i);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            o oVar = this.f10058a;
            if (i >= oVar.f9953a.size()) {
                bundle.putIntegerArrayList(f10057c, arrayList);
                return bundle;
            }
            arrayList.add(Integer.valueOf(oVar.b(i)));
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s0) {
            return this.f10058a.equals(((s0) obj).f10058a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10058a.hashCode();
    }
}
