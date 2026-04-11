package va;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13463b;

    public o() {
        this.f13462a = new ArrayList();
        this.f13463b = 128;
    }

    public synchronized List a() {
        return Collections.unmodifiableList(new ArrayList(this.f13462a));
    }

    public boolean b() {
        return this.f13463b < this.f13462a.size();
    }

    public synchronized boolean c(List list) {
        this.f13462a.clear();
        if (list.size() <= this.f13463b) {
            return this.f13462a.addAll(list);
        }
        Log.w("FirebaseCrashlytics", "Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f13463b, null);
        return this.f13462a.addAll(list.subList(0, this.f13463b));
    }

    public o(ArrayList arrayList) {
        this.f13462a = arrayList;
    }
}
