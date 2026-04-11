package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.gms.internal.measurement.j4;
import g7.x;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import w4.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f2198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2199b;

    public static final void C(Object obj) throws Throwable {
        if (obj instanceof rd.g) {
            throw ((rd.g) obj).f10995v;
        }
    }

    public static int D(int i) {
        int[] iArr = {1, 2, 3};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr[i10];
            int i12 = i11 - 1;
            if (i11 == 0) {
                throw null;
            }
            if (i12 == i) {
                return i11;
            }
        }
        return 1;
    }

    public static final void a(File file, long j4) throws IOException {
        if (!file.exists()) {
            android.support.v4.media.session.b.g(file);
        }
        if (file.length() != j4 && j4 > 0) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(j4);
                randomAccessFile.close();
            } catch (Exception unused) {
                throw new IOException("file_allocation_error");
            }
        }
    }

    public static void b(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static final int c(c5.c cVar, String str) {
        ge.i.e(cVar, "<this>");
        int iD = d(cVar, str);
        if (iD >= 0) {
            return iD;
        }
        int iD2 = d(cVar, "`" + str + '`');
        if (iD2 >= 0) {
            return iD2;
        }
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        int columnCount = cVar.getColumnCount();
        String strConcat = ".".concat(str);
        String str2 = "." + str + '`';
        for (int i = 0; i < columnCount; i++) {
            String columnName = cVar.getColumnName(i);
            if (columnName.length() >= str.length() + 2 && (ne.o.V(columnName, strConcat) || (columnName.charAt(0) == '`' && ne.o.V(columnName, str2)))) {
                return i;
            }
        }
        return -1;
    }

    public static final int d(c5.c cVar, String str) {
        ge.i.e(cVar, "<this>");
        ge.i.e(str, "name");
        int columnCount = cVar.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if (str.equals(cVar.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

    public static final rd.g e(Throwable th) {
        ge.i.e(th, "exception");
        return new rd.g(th);
    }

    public static final String f(String str, boolean z10) {
        ge.i.e(str, "filePath");
        if (!z10) {
            android.support.v4.media.session.b.g(new File(str));
            return str;
        }
        File file = new File(str);
        if (file.exists()) {
            String strJ = l0.e.j(file.getParent(), "/");
            String name = file.getName();
            ge.i.d(name, "getName(...)");
            String strR0 = ne.h.r0('.', name, "");
            String strM = ce.a.M(file);
            int i = 0;
            while (file.exists()) {
                i++;
                file = new File(strJ + (strM + " (" + i + ")") + "." + strR0);
            }
        }
        android.support.v4.media.session.b.g(file);
        String absolutePath = file.getAbsolutePath();
        ge.i.b(absolutePath);
        return absolutePath;
    }

    public static final q g(Context context, Class cls, String str) {
        ge.i.e(context, "context");
        if (str == null || ne.h.k0(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        if (ge.i.a(str, ":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new q(context, cls, str);
    }

    public static boolean h(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static ColorStateList i(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListC;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = i0.c.c(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListC;
    }

    public static ColorStateList j(Context context, l7.a aVar, int i) {
        int resourceId;
        ColorStateList colorStateListC;
        TypedArray typedArray = (TypedArray) aVar.f7867x;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = i0.c.c(context, resourceId)) == null) ? aVar.r(i) : colorStateListC;
    }

    public static final int k(c5.c cVar, String str) {
        ge.i.e(cVar, "stmt");
        int iC = c(cVar, str);
        if (iC >= 0) {
            return iC;
        }
        int columnCount = cVar.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(cVar.getColumnName(i));
        }
        throw new IllegalArgumentException("Column '" + str + "' does not exist. Available columns: [" + sd.j.l0(arrayList, null, null, null, null, 63) + ']');
    }

    public static Drawable l(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableI;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableI = j4.i(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableI;
    }

    public static final cd.b m(String str) {
        cd.b bVar = cd.b.f2151x;
        return (str == null || str.length() == 0) ? bVar : (str.equalsIgnoreCase("request_with_file_path_already_exist") || ne.h.c0(str, "UNIQUE constraint failed: requests._file (code 2067)", true)) ? cd.b.L : ne.h.c0(str, "UNIQUE constraint failed: requests._id", false) ? cd.b.K : ne.h.c0(str, "empty_response_body", true) ? cd.b.G : (str.equalsIgnoreCase("FNC") || str.equalsIgnoreCase("open failed: ENOENT (No such file or directory)")) ? cd.b.f2153z : (ne.h.c0(str, "recvfrom failed: ETIMEDOUT (Connection timed out)", true) || ne.h.c0(str, "timeout", true) || ne.h.c0(str, "Software caused connection abort", true) || ne.h.c0(str, "Read timed out at", true)) ? cd.b.A : (str.equalsIgnoreCase("java.io.IOException: 404") || ne.h.c0(str, "No address associated with hostname", false)) ? cd.b.C : ne.h.c0(str, "Unable to resolve host", false) ? cd.b.B : str.equalsIgnoreCase("open failed: EACCES (Permission denied)") ? cd.b.D : (str.equalsIgnoreCase("write failed: ENOSPC (No space left on device)") || str.equalsIgnoreCase("database or disk is full (code 13)")) ? cd.b.E : str.equalsIgnoreCase("UNIQUE constraint failed: requests._id (code 1555)") ? cd.b.H : str.equalsIgnoreCase("fetch download not found") ? cd.b.I : str.equalsIgnoreCase("Fetch data base error") ? cd.b.J : (ne.h.c0(str, "request_not_successful", true) || ne.h.c0(str, "Failed to connect", true)) ? cd.b.M : ne.h.c0(str, "invalid content hash", true) ? cd.b.Q : ne.h.c0(str, "download_incomplete", true) ? cd.b.N : ne.h.c0(str, "failed_to_update_request", true) ? cd.b.R : ne.h.c0(str, "failed_to_add_completed_download", true) ? cd.b.S : ne.h.c0(str, "fetch_file_server_invalid_response_type", true) ? cd.b.T : ne.h.c0(str, "request_does_not_exist", true) ? cd.b.U : ne.h.c0(str, "no_network_connection", true) ? cd.b.F : ne.h.c0(str, "file_not_found", true) ? cd.b.O : ne.h.c0(str, "fetch_file_server_url_invalid", true) ? cd.b.P : ne.h.c0(str, "request_list_not_distinct", true) ? cd.b.X : ne.h.c0(str, "enqueue_not_successful", true) ? cd.b.V : ne.h.c0(str, "cannot rename file associated with incomplete download", true) ? cd.b.Y : ne.h.c0(str, "file_cannot_be_renamed", true) ? cd.b.Z : ne.h.c0(str, "file_allocation_error", true) ? cd.b.f2147a0 : ne.h.c0(str, "Cleartext HTTP traffic to", true) ? cd.b.f2148b0 : bVar;
    }

    public static final cd.b n(Exception exc) {
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        boolean z10 = exc instanceof SocketTimeoutException;
        if (z10 && message.length() == 0) {
            message = "timeout";
        }
        cd.b bVarM = m(message);
        cd.b bVar = cd.b.f2151x;
        return (bVarM == bVar && z10) ? cd.b.A : (bVarM == bVar && (exc instanceof IOException)) ? cd.b.N : bVarM;
    }

    public static int o(List list, InputStream inputStream, a7.g gVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new x(inputStream, gVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int iF = ((x6.d) list.get(i)).f(inputStream, gVar);
                if (iF != -1) {
                    return iF;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static final md.o p(File file) throws FileNotFoundException {
        if (file.exists()) {
            return new md.o(new RandomAccessFile(file, "rw"));
        }
        throw new FileNotFoundException(l0.e.j(file.getCanonicalPath(), " file_not_found"));
    }

    public static final md.o q(String str, ContentResolver contentResolver) throws FileNotFoundException {
        ge.i.e(str, "filePath");
        if (!android.support.v4.media.session.b.E(str)) {
            return p(new File(str));
        }
        Uri uri = Uri.parse(str);
        ge.i.d(uri, "parse(...)");
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                        ge.i.d(fileDescriptor, "getFileDescriptor(...)");
                        return new md.o(new FileOutputStream(fileDescriptor));
                    }
                    throw new FileNotFoundException(uri + " file_not_found");
                }
            } else if (scheme.equals("file")) {
                File file = new File(String.valueOf(uri.getPath()));
                if (file.exists() && file.canWrite()) {
                    return p(file);
                }
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = contentResolver.openFileDescriptor(uri, "w");
                if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                    FileDescriptor fileDescriptor2 = parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor();
                    ge.i.d(fileDescriptor2, "getFileDescriptor(...)");
                    return new md.o(new FileOutputStream(fileDescriptor2));
                }
                throw new FileNotFoundException(uri + " file_not_found");
            }
        }
        throw new FileNotFoundException(uri + " file_not_found");
    }

    public static final int r(int i, int i10, int i11) {
        if (i11 > 0) {
            if (i < i10) {
                int i12 = i10 % i11;
                if (i12 < 0) {
                    i12 += i11;
                }
                int i13 = i % i11;
                if (i13 < 0) {
                    i13 += i11;
                }
                int i14 = (i12 - i13) % i11;
                if (i14 < 0) {
                    i14 += i11;
                }
                return i10 - i14;
            }
        } else {
            if (i11 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i10) {
                int i15 = -i11;
                int i16 = i % i15;
                if (i16 < 0) {
                    i16 += i15;
                }
                int i17 = i10 % i15;
                if (i17 < 0) {
                    i17 += i15;
                }
                int i18 = (i16 - i17) % i15;
                if (i18 < 0) {
                    i18 += i15;
                }
                return i18 + i10;
            }
        }
        return i10;
    }

    public static ImageHeaderParser$ImageType t(List list, InputStream inputStream, a7.g gVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new x(inputStream, gVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeE = ((x6.d) list.get(i)).e(inputStream);
                inputStream.reset();
                if (imageHeaderParser$ImageTypeE != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeE;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType u(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeA = ((x6.d) list.get(i)).a(byteBuffer);
                AtomicReference atomicReference = s7.b.f11590a;
                if (imageHeaderParser$ImageTypeA != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeA;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = s7.b.f11590a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static e5.c x(p6.d dVar, SQLiteDatabase sQLiteDatabase) {
        ge.i.e(dVar, "refHolder");
        e5.c cVar = (e5.c) dVar.f10037w;
        if (cVar != null && cVar.f3786v.equals(sQLiteDatabase)) {
            return cVar;
        }
        e5.c cVar2 = new e5.c(sQLiteDatabase);
        dVar.f10037w = cVar2;
        return cVar2;
    }

    public static boolean y() {
        if (Build.VERSION.SDK_INT >= 29) {
            return k5.a.a();
        }
        try {
            if (f2199b == null) {
                f2198a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2199b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2199b.invoke(null, Long.valueOf(f2198a))).booleanValue();
        } catch (Exception e9) {
            if (!(e9 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e9);
                return false;
            }
            Throwable cause = e9.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean z(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public abstract void A(Throwable th);

    public abstract void B(b6.f fVar);

    public abstract int s(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int v();

    public abstract ViewPropertyAnimator w(View view, int i);
}
