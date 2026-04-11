package f9;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.cardview.widget.CardView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.m8;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.s8;
import com.google.android.gms.internal.measurement.u7;
import com.google.android.gms.internal.measurement.v8;
import com.google.android.gms.internal.measurement.x7;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements w, g7.f0, g8.a, j6.b, md.k, t4.b, t7.a, vb.c, w8.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3999v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ a0 f3995w = new a0(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ a0 f3996x = new a0(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ a0 f3997y = new a0(2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ a0 f3998z = new a0(3);
    public static final /* synthetic */ a0 A = new a0(4);
    public static final /* synthetic */ a0 B = new a0(5);
    public static final /* synthetic */ a0 C = new a0(6);
    public static final /* synthetic */ a0 D = new a0(7);
    public static final /* synthetic */ a0 E = new a0(8);
    public static final /* synthetic */ a0 F = new a0(9);
    public static final /* synthetic */ a0 G = new a0(10);

    public /* synthetic */ a0(int i) {
        this.f3999v = i;
    }

    public static vb.a g(a0 a0Var) {
        return new vb.a(System.currentTimeMillis() + ((long) 3600000), new q6.l(8), new i2.g(true, false, false), 10.0d, 1.2d, 60);
    }

    public static i4.e k(w2.h hVar, ag.o oVar) {
        IOException iOException = (IOException) oVar.f455x;
        if (!(iOException instanceof b2.a0)) {
            return null;
        }
        int i = ((b2.a0) iOException).f1671y;
        if (i != 403 && i != 404 && i != 410 && i != 416 && i != 500 && i != 503) {
            return null;
        }
        if (hVar.a(1)) {
            return new i4.e(1, 300000L);
        }
        if (hVar.a(2)) {
            return new i4.e(2, 60000L);
        }
        return null;
    }

    public static long q(ag.o oVar) {
        Throwable cause = (IOException) oVar.f455x;
        if ((cause instanceof v1.n0) || (cause instanceof FileNotFoundException) || (cause instanceof b2.x) || (cause instanceof w2.n)) {
            return -9223372036854775807L;
        }
        int i = b2.l.f1700w;
        while (cause != null) {
            if ((cause instanceof b2.l) && ((b2.l) cause).f1701v == 2008) {
                return -9223372036854775807L;
            }
            cause = cause.getCause();
        }
        return Math.min((oVar.f454w - 1) * 1000, 5000);
    }

    @Override // md.k
    public boolean E() {
        return false;
    }

    @Override // f9.w
    public Object a() {
        switch (this.f3999v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                List list = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2444w0.b();
            case 1:
                List list2 = f0.f4108a;
                d7.f2368w.get();
                Long l10 = (Long) f7.Z.b();
                l10.getClass();
                return l10;
            case 2:
                List list3 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2441v.b()).longValue());
            case 3:
                List list4 = f0.f4108a;
                Boolean bool = (Boolean) x7.f2727b.b();
                bool.getClass();
                return bool;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                List list5 = f0.f4108a;
                Boolean bool2 = (Boolean) m8.f2535a.b();
                bool2.getClass();
                return bool2;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                List list6 = f0.f4108a;
                Boolean bool3 = (Boolean) u7.f2650a.b();
                bool3.getClass();
                return bool3;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                List list7 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool4 = (Boolean) s8.f.b();
                bool4.getClass();
                return bool4;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                List list8 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool5 = (Boolean) s8.f2627g.b();
                bool5.getClass();
                return bool5;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                List list9 = f0.f4108a;
                Boolean bool6 = (Boolean) o7.f2562a.b();
                bool6.getClass();
                return bool6;
            case 9:
                List list10 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2427n0.b()).longValue());
            default:
                return new Boolean(((Boolean) v8.f2673a.b()).booleanValue());
        }
    }

    @Override // j6.b
    public float b() {
        return 1.0f;
    }

    @Override // j6.b
    public boolean c(float f) {
        throw new IllegalStateException("not implemented");
    }

    @Override // j6.b
    public float d() {
        return 0.0f;
    }

    @Override // j6.b
    public t6.a e() {
        throw new IllegalStateException("not implemented");
    }

    @Override // j6.b
    public boolean f(float f) {
        return false;
    }

    @Override // t4.b
    public void h() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // vb.c
    public vb.a i(a0 a0Var, JSONObject jSONObject) {
        return g(a0Var);
    }

    @Override // j6.b
    public boolean isEmpty() {
        return true;
    }

    @Override // t4.b
    public void j(int i, Object obj) {
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
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                str = "RESULT_NOT_WRITABLE";
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "RESULT_IO_EXCEPTION";
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
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

    @Override // g8.a
    public long l() {
        return SystemClock.elapsedRealtime();
    }

    public int m(int i) {
        return i == 7 ? 6 : 3;
    }

    @Override // w8.c
    public a3.d n(Context context, String str, w8.b bVar) {
        int iE;
        a3.d dVar = new a3.d();
        int iG = bVar.g(context, str);
        dVar.f154a = iG;
        int i = 1;
        int i10 = 0;
        if (iG != 0) {
            iE = bVar.e(context, str, false);
            dVar.f155b = iE;
        } else {
            iE = bVar.e(context, str, true);
            dVar.f155b = iE;
        }
        int i11 = dVar.f154a;
        if (i11 == 0) {
            if (iE == 0) {
                i = 0;
            }
            dVar.f156c = i;
            return dVar;
        }
        i10 = i11;
        if (i10 >= iE) {
            i = -1;
        }
        dVar.f156c = i;
        return dVar;
    }

    @Override // t7.a
    public Object o() {
        return new ArrayList();
    }

    @Override // g7.f0
    public void p(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    public void r(nb.w wVar, float f) {
        u.a aVar = (u.a) ((Drawable) wVar.f9016w);
        CardView cardView = (CardView) wVar.f9017x;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != aVar.f12037e || aVar.f != useCompatPadding || aVar.f12038g != preventCornerOverlap) {
            aVar.f12037e = f;
            aVar.f = useCompatPadding;
            aVar.f12038g = preventCornerOverlap;
            aVar.b(null);
            aVar.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            wVar.P(0, 0, 0, 0);
            return;
        }
        u.a aVar2 = (u.a) ((Drawable) wVar.f9016w);
        float f10 = aVar2.f12037e;
        float f11 = aVar2.f12033a;
        int iCeil = (int) Math.ceil(u.b.a(f10, f11, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(u.b.b(f10, f11, cardView.getPreventCornerOverlap()));
        wVar.P(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // g7.f0
    public void v(MediaExtractor mediaExtractor, Object obj) throws IOException {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    public a0() {
        this.f3999v = 11;
        if (Build.VERSION.SDK_INT >= 35) {
        }
    }
}
