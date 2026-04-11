package of;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9855b;

    public t() {
        this.f9854a = new ArrayList();
        this.f9855b = 128;
    }

    public synchronized List a() {
        return Collections.unmodifiableList(new ArrayList(this.f9854a));
    }

    public synchronized boolean b(List list) {
        this.f9854a.clear();
        if (list.size() <= this.f9855b) {
            return this.f9854a.addAll(list);
        }
        Log.w("FirebaseCrashlytics", "Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f9855b, null);
        return this.f9854a.addAll(list.subList(0, this.f9855b));
    }

    public t(ArrayList arrayList) {
        this.f9854a = arrayList;
    }
}
