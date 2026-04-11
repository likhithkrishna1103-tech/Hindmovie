package wa;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.window.BackEvent;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f14037a = true;

    public static void A(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iE = E(parcel, i);
        parcel.writeStrongBinder(iBinder);
        G(parcel, iE);
    }

    public static void B(Parcel parcel, int i, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            return;
        }
        int iE = E(parcel, i);
        parcelable.writeToParcel(parcel, i10);
        G(parcel, iE);
    }

    public static void C(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iE = E(parcel, i);
        parcel.writeString(str);
        G(parcel, iE);
    }

    public static void D(Parcel parcel, int i, Parcelable[] parcelableArr, int i10) {
        if (parcelableArr == null) {
            return;
        }
        int iE = E(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i10);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        G(parcel, iE);
    }

    public static int E(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static Object F(o8.o oVar) throws ExecutionException {
        if (oVar.j()) {
            return oVar.h();
        }
        if (oVar.f9442d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(oVar.g());
    }

    public static void G(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void H(Parcel parcel, int i, int i10) {
        parcel.writeInt(i | (i10 << 16));
    }

    public static final j4.b a(BackEvent backEvent) {
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        return new j4.b(backEvent.getSwipeEdge(), backEvent.getProgress(), touchX, touchY, Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
    }

    public static Object b(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static final void c(xe.a aVar, xe.b bVar, String str) {
        xe.c.f14365h.getClass();
        xe.c.f14366j.fine(bVar.f14361b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f14356a);
    }

    public static Object d(o8.o oVar) throws InterruptedException {
        t7.v.g("Must not be called on the main application thread");
        t7.v.f();
        t7.v.i(oVar, "Task must not be null");
        if (oVar.i()) {
            return F(oVar);
        }
        o4.c cVar = new o4.c(1);
        Executor executor = o8.i.f9423b;
        oVar.d(executor, cVar);
        oVar.c(executor, cVar);
        oVar.a(executor, cVar);
        ((CountDownLatch) cVar.f9349u).await();
        return F(oVar);
    }

    public static Object e(o8.o oVar, long j5, TimeUnit timeUnit) throws TimeoutException {
        t7.v.g("Must not be called on the main application thread");
        t7.v.f();
        t7.v.i(oVar, "Task must not be null");
        t7.v.i(timeUnit, "TimeUnit must not be null");
        if (oVar.i()) {
            return F(oVar);
        }
        o4.c cVar = new o4.c(1);
        Executor executor = o8.i.f9423b;
        oVar.d(executor, cVar);
        oVar.c(executor, cVar);
        oVar.a(executor, cVar);
        if (((CountDownLatch) cVar.f9349u).await(j5, timeUnit)) {
            return F(oVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static o8.o f(Executor executor, Callable callable) {
        t7.v.i(executor, "Executor must not be null");
        o8.o oVar = new o8.o();
        executor.execute(new ea.t(oVar, 28, callable));
        return oVar;
    }

    public static int g(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static long[] h(long[]... jArr) {
        long length = 0;
        for (long[] jArr2 : jArr) {
            length += (long) jArr2.length;
        }
        int i = (int) length;
        q1.c.f(length, "the total number of elements (%s) in the arrays must fit in an int", length == ((long) i));
        long[] jArr3 = new long[i];
        int length2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, length2, jArr4.length);
            length2 += jArr4.length;
        }
        return jArr3;
    }

    public static Parcelable i(Parcelable parcelable, Parcelable.Creator creator) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static o8.o j(Exception exc) {
        o8.o oVar = new o8.o();
        oVar.l(exc);
        return oVar;
    }

    public static o8.o k(Object obj) {
        o8.o oVar = new o8.o();
        oVar.m(obj);
        return oVar;
    }

    public static final String l(long j5) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j5 <= -999500000 ? l4.a.n(new StringBuilder(), (j5 - ((long) 500000000)) / ((long) 1000000000), " s ") : j5 <= -999500 ? l4.a.n(new StringBuilder(), (j5 - ((long) 500000)) / ((long) 1000000), " ms") : j5 <= 0 ? l4.a.n(new StringBuilder(), (j5 - ((long) 500)) / ((long) 1000), " µs") : j5 < 999500 ? l4.a.n(new StringBuilder(), (j5 + ((long) 500)) / ((long) 1000), " µs") : j5 < 999500000 ? l4.a.n(new StringBuilder(), (j5 + ((long) 500000)) / ((long) 1000000), " ms") : l4.a.n(new StringBuilder(), (j5 + ((long) 500000000)) / ((long) 1000000000), " s ")}, 1));
    }

    public static final int m(Cursor cursor, String str) {
        String string;
        be.h.e(cursor, "c");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    be.h.b(columnNames);
                    String strConcat = ".".concat(str);
                    String str2 = "." + str + '`';
                    int length = columnNames.length;
                    int i = 0;
                    int i10 = 0;
                    while (i10 < length) {
                        String str3 = columnNames[i10];
                        int i11 = i + 1;
                        if (str3.length() >= str.length() + 2 && (ie.n.H(str3, strConcat) || (str3.charAt(0) == '`' && ie.n.H(str3, str2)))) {
                            columnIndex = i;
                            break;
                        }
                        i10++;
                        i = i11;
                    }
                    columnIndex = -1;
                } else {
                    columnIndex = -1;
                }
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames2 = cursor.getColumnNames();
            be.h.d(columnNames2, "getColumnNames(...)");
            StringBuilder sb2 = new StringBuilder();
            sb2.append((CharSequence) "");
            int i12 = 0;
            for (String str4 : columnNames2) {
                i12++;
                if (i12 > 1) {
                    sb2.append((CharSequence) ", ");
                }
                cf.l.b(sb2, str4, null);
            }
            sb2.append((CharSequence) "");
            string = sb2.toString();
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            string = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + string);
    }

    public static Drawable n(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (f14037a) {
                return u(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e10;
            }
            return context2.getDrawable(i);
        } catch (NoClassDefFoundError unused2) {
            f14037a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = h0.k.f5599a;
        return resources.getDrawable(i, theme);
    }

    public static int o(List list, InputStream inputStream, f6.f fVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new l6.v(inputStream, fVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int iC = ((c6.e) list.get(i)).c(inputStream, fVar);
                if (iC != -1) {
                    return iC;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType p(List list, InputStream inputStream, f6.f fVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new l6.v(inputStream, fVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeD = ((c6.e) list.get(i)).d(inputStream);
                inputStream.reset();
                if (imageHeaderParser$ImageTypeD != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeD;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType q(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeA = ((c6.e) list.get(i)).a(byteBuffer);
                AtomicReference atomicReference = x6.b.f14274a;
                if (imageHeaderParser$ImageTypeA != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeA;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = x6.b.f14274a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static int r(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean s(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static String t(String str, Object... objArr) {
        int iIndexOf;
        String string;
        int i = 0;
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e10) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e10);
                    string = "<" + str2 + " threw " + e10.getClass().getName() + ">";
                }
            }
            objArr[i10] = string;
        }
        StringBuilder sb2 = new StringBuilder((objArr.length * 16) + str.length());
        int i11 = 0;
        while (i < objArr.length && (iIndexOf = str.indexOf("%s", i11)) != -1) {
            sb2.append((CharSequence) str, i11, iIndexOf);
            sb2.append(objArr[i]);
            i11 = iIndexOf + 2;
            i++;
        }
        sb2.append((CharSequence) str, i11, str.length());
        if (i < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i]);
            for (int i12 = i + 1; i12 < objArr.length; i12++) {
                sb2.append(", ");
                sb2.append(objArr[i12]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public static Drawable u(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            l.c cVar = new l.c(context);
            cVar.f7754b = theme;
            cVar.a(theme.getResources().getConfiguration());
            context = cVar;
        }
        return com.bumptech.glide.d.p(context, i);
    }

    public static Uri v(Uri uri) {
        if (uri.getQueryParameter("CMCD") == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str : uri.getQueryParameterNames()) {
            if (!str.equals("CMCD")) {
                Iterator<String> it = uri.getQueryParameters(str).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    public static String w(int i) {
        Object[] objArr = {Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d)};
        int i10 = s1.b0.f11647a;
        return String.format(Locale.US, "rgba(%d,%d,%d,%.3f)", objArr);
    }

    public static o8.o x(List list) {
        if (list == null || list.isEmpty()) {
            return k(null);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((o8.o) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        o8.o oVar = new o8.o();
        o8.k kVar = new o8.k(list.size(), oVar);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            o8.o oVar2 = (o8.o) it2.next();
            h.p pVar = o8.i.f9423b;
            oVar2.d(pVar, kVar);
            oVar2.c(pVar, kVar);
            oVar2.a(pVar, kVar);
        }
        return oVar;
    }

    public static o8.o y(o8.o... oVarArr) {
        if (oVarArr.length == 0) {
            return k(Collections.EMPTY_LIST);
        }
        List listAsList = Arrays.asList(oVarArr);
        c7.r rVar = o8.i.f9422a;
        if (listAsList == null || listAsList.isEmpty()) {
            return k(Collections.EMPTY_LIST);
        }
        List list = listAsList;
        return x(list).f(rVar, new o8.j(0, list));
    }

    public static void z(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iE = E(parcel, i);
        parcel.writeBundle(bundle);
        G(parcel, iE);
    }
}
