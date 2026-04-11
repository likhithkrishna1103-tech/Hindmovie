package m0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f8286a;

    public j(Object obj) {
        this.f8286a = j2.e.f(obj);
    }

    @Override // m0.i
    public final String a() {
        return this.f8286a.toLanguageTags();
    }

    @Override // m0.i
    public final Object b() {
        return this.f8286a;
    }

    public final boolean equals(Object obj) {
        return this.f8286a.equals(((i) obj).b());
    }

    @Override // m0.i
    public final Locale get(int i) {
        return this.f8286a.get(i);
    }

    public final int hashCode() {
        return this.f8286a.hashCode();
    }

    @Override // m0.i
    public final boolean isEmpty() {
        return this.f8286a.isEmpty();
    }

    @Override // m0.i
    public final int size() {
        return this.f8286a.size();
    }

    public final String toString() {
        return this.f8286a.toString();
    }
}
