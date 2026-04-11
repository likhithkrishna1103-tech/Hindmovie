package c;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f2200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f2201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f2202c;

    public y(Field field, Field field2, Field field3) {
        this.f2200a = field;
        this.f2201b = field2;
        this.f2202c = field3;
    }

    @Override // c.w
    public final boolean a(InputMethodManager inputMethodManager) {
        try {
            this.f2202c.set(inputMethodManager, null);
            return true;
        } catch (IllegalAccessException unused) {
            return false;
        }
    }

    @Override // c.w
    public final Object b(InputMethodManager inputMethodManager) {
        try {
            return this.f2200a.get(inputMethodManager);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    @Override // c.w
    public final View c(InputMethodManager inputMethodManager) {
        try {
            return (View) this.f2201b.get(inputMethodManager);
        } catch (ClassCastException | IllegalAccessException unused) {
            return null;
        }
    }
}
