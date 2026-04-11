package c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1991v;

    public /* synthetic */ x(int i) {
        this.f1991v = i;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, rd.c] */
    @Override // fe.a
    public final Object b() {
        Class<?> returnType;
        bf.d[] dVarArr;
        switch (this.f1991v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                rd.j jVar = ImmLeaksCleaner.f512w;
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    declaredField3.setAccessible(true);
                    return new a0(declaredField3, declaredField, declaredField2);
                } catch (NoSuchFieldException unused) {
                    return z.f1992a;
                }
            case 1:
                ArrayList arrayList = new ArrayList(0);
                ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
                return (arrayList2 == null || (dVarArr = (bf.d[]) arrayList2.toArray(new bf.d[0])) == null) ? df.k.f3712a : dVarArr;
            case 2:
                ie.a aVar = ie.e.f6451v;
                return Integer.valueOf(ie.e.f6451v.a().nextInt(2147418112) + 65536);
            case 3:
                try {
                    Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Throwable unused2) {
                    return null;
                }
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                try {
                    Method method = (Method) e5.c.f3784x.getValue();
                    if (method == null || (returnType = method.getReturnType()) == null) {
                        return null;
                    }
                    Class<?> cls = Integer.TYPE;
                    return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
                } catch (Throwable unused3) {
                    return null;
                }
            default:
                return Boolean.TRUE;
        }
    }

    public /* synthetic */ x(df.n nVar) {
        this.f1991v = 1;
    }
}
