package k8;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.a8;
import com.google.android.gms.internal.measurement.a9;
import com.google.android.gms.internal.measurement.b8;
import com.google.android.gms.internal.measurement.c8;
import com.google.android.gms.internal.measurement.d8;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.n9;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.v7;
import com.google.android.gms.internal.measurement.v8;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.x7;
import com.google.android.gms.internal.measurement.y8;
import com.google.android.gms.internal.measurement.z6;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements e0, l6.c0, l7.a, o4.d, p2.n, q0.t, r3.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static a0 f7067v;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7068u;

    public /* synthetic */ a0(int i) {
        this.f7068u = i;
    }

    public static byte[] h(aa.j0 j0Var, long j5) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(j0Var.size());
        Iterator<E> it = j0Var.iterator();
        while (it.hasNext()) {
            r1.b bVar = (r1.b) it.next();
            Bundle bundleB = bVar.b();
            Bitmap bitmap = bVar.f11256d;
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                s1.d.g(bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
                bundleB.putByteArray(r1.b.f11250x, byteArrayOutputStream.toByteArray());
            }
            arrayList.add(bundleB);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j5);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static u5.a i(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new u5.a(httpURLConnection);
    }

    public static e4.f j(j9.j0 j0Var, e6.i iVar) {
        IOException iOException = (IOException) iVar.f4523v;
        if (!(iOException instanceof v1.x)) {
            return null;
        }
        int i = ((v1.x) iOException).f13177x;
        if (i != 403 && i != 404 && i != 410 && i != 416 && i != 500 && i != 503) {
            return null;
        }
        if (j0Var.a(1)) {
            return new e4.f(1, 300000L);
        }
        if (j0Var.a(2)) {
            return new e4.f(2, 60000L);
        }
        return null;
    }

    public static long n(e6.i iVar) {
        Throwable cause = (IOException) iVar.f4523v;
        if ((cause instanceof p1.n0) || (cause instanceof FileNotFoundException) || (cause instanceof v1.u) || (cause instanceof s2.l)) {
            return -9223372036854775807L;
        }
        int i = v1.j.f13143v;
        while (cause != null) {
            if ((cause instanceof v1.j) && ((v1.j) cause).f13144u == 2008) {
                return -9223372036854775807L;
            }
            cause = cause.getCause();
        }
        return Math.min((iVar.f4522u - 1) * 1000, 5000);
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f7068u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3281r.a()).longValue());
            case 1:
                y8.f3250v.get();
                Long l10 = (Long) a9.f2894e.a();
                l10.getClass();
                return l10;
            case 2:
                x6.f3236v.get();
                Long l11 = (Long) z6.f3269e.a();
                l11.getClass();
                return l11;
            case 3:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3278o.a()).longValue());
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                a8.f2888v.get();
                Boolean bool = (Boolean) c8.f2923a.a();
                bool.getClass();
                return bool;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                x6.f3236v.get();
                return (String) z6.f3271g.a();
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                x6.f3236v.get();
                return (String) z6.A.a();
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                x6.f3236v.get();
                return (String) z6.J.a();
            case 8:
                x6.f3236v.get();
                return (String) z6.f.a();
            case 9:
                v7.f3218v.get();
                Boolean bool2 = (Boolean) x7.f3239b.a();
                bool2.getClass();
                return bool2;
            case 10:
                t8.f3205v.get();
                Boolean bool3 = (Boolean) v8.f3220a.a();
                bool3.getClass();
                return bool3;
            case 11:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.R.a()).longValue());
            case 12:
                l9.f3091v.get();
                Boolean bool4 = (Boolean) n9.f3130d.a();
                bool4.getClass();
                return bool4;
            case 13:
                x6.f3236v.get();
                return (String) z6.E.a();
            case 14:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.Z.a()).longValue());
            default:
                b8.f2904v.get();
                Boolean bool5 = (Boolean) d8.f2940a.a();
                bool5.getClass();
                return bool5;
        }
    }

    @Override // p2.n
    public long b() {
        throw new NoSuchElementException();
    }

    @Override // r3.g
    public w2.b0 c() {
        return new w2.t(-9223372036854775807L);
    }

    @Override // r3.g
    public long d(w2.p pVar) {
        return -1L;
    }

    @Override // p2.n
    public long e() {
        throw new NoSuchElementException();
    }

    @Override // l7.a
    public long g() {
        return SystemClock.elapsedRealtime();
    }

    public int k(int i) {
        return i == 7 ? 6 : 3;
    }

    @Override // o4.d
    public void l() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // o4.d
    public void m(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                str = "RESULT_NOT_WRITABLE";
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    @Override // p2.n
    public boolean next() {
        return false;
    }

    @Override // l6.c0
    public void o(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // l6.c0
    public void q(MediaExtractor mediaExtractor, Object obj) throws IOException {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // r3.g
    public void f(long j5) {
    }

    @Override // q0.t
    public void onScrollLimit(int i, int i10, int i11, boolean z2) {
    }

    @Override // q0.t
    public void onScrollProgress(int i, int i10, int i11, int i12) {
    }
}
