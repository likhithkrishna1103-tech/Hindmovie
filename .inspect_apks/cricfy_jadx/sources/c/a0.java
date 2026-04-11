package c;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f1929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f1930c;

    public a0(Field field, Field field2, Field field3) {
        this.f1928a = field;
        this.f1929b = field2;
        this.f1930c = field3;
    }

    @Override // c.y
    public final boolean a(InputMethodManager inputMethodManager) {
        try {
            this.f1930c.set(inputMethodManager, null);
            return true;
        } catch (IllegalAccessException unused) {
            return false;
        }
    }

    @Override // c.y
    public final Object b(InputMethodManager inputMethodManager) {
        try {
            return this.f1928a.get(inputMethodManager);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    @Override // c.y
    public final View c(InputMethodManager inputMethodManager) {
        try {
            return (View) this.f1929b.get(inputMethodManager);
        } catch (ClassCastException | IllegalAccessException unused) {
            return null;
        }
    }
}
