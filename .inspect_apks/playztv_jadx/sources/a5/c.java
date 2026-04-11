package a5;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import androidx.media3.decoder.DecoderInputBuffer;
import c.x;
import c.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements ae.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f541u;

    public /* synthetic */ c(int i) {
        this.f541u = i;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, nd.c] */
    @Override // ae.a
    public final Object b() {
        Class<?> returnType;
        switch (this.f541u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Throwable unused) {
                    return null;
                }
            case 1:
                try {
                    Method method = (Method) d.f543w.getValue();
                    if (method == null || (returnType = method.getReturnType()) == null) {
                        return null;
                    }
                    Class<?> cls = Integer.TYPE;
                    return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
                } catch (Throwable unused2) {
                    return null;
                }
            case 2:
                nd.i iVar = ImmLeaksCleaner.f852v;
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    declaredField3.setAccessible(true);
                    return new y(declaredField3, declaredField, declaredField2);
                } catch (NoSuchFieldException unused3) {
                    return x.f2199a;
                }
            case 3:
                de.a aVar = de.d.f4189u;
                return Integer.valueOf(de.d.f4189u.a().nextInt(2147418112) + 65536);
            default:
                return Boolean.TRUE;
        }
    }
}
