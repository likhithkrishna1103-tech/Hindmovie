package p0;

import android.os.LocaleList;
import i2.a0;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f9878a;

    public j(Object obj) {
        this.f9878a = a0.g(obj);
    }

    @Override // p0.i
    public final String a() {
        return this.f9878a.toLanguageTags();
    }

    @Override // p0.i
    public final Object b() {
        return this.f9878a;
    }

    public final boolean equals(Object obj) {
        return this.f9878a.equals(((i) obj).b());
    }

    @Override // p0.i
    public final Locale get(int i) {
        return this.f9878a.get(i);
    }

    public final int hashCode() {
        return this.f9878a.hashCode();
    }

    @Override // p0.i
    public final boolean isEmpty() {
        return this.f9878a.isEmpty();
    }

    @Override // p0.i
    public final int size() {
        return this.f9878a.size();
    }

    public final String toString() {
        return this.f9878a.toString();
    }
}
