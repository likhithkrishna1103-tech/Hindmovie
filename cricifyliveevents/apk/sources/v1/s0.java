package v1;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0 f12988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12989c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f12990a;

    static {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        y1.d.g(!false);
        f12988b = new s0(new n(sparseBooleanArray));
        int i = y1.a0.f14551a;
        f12989c = Integer.toString(0, 36);
    }

    public s0(n nVar) {
        this.f12990a = nVar;
    }

    public final boolean a(int i) {
        return this.f12990a.f12877a.get(i);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            n nVar = this.f12990a;
            if (i >= nVar.f12877a.size()) {
                bundle.putIntegerArrayList(f12989c, arrayList);
                return bundle;
            }
            arrayList.add(Integer.valueOf(nVar.b(i)));
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s0) {
            return this.f12990a.equals(((s0) obj).f12990a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12990a.hashCode();
    }
}
