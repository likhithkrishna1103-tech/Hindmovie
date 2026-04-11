package q4;

import a3.i0;
import a9.b;
import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import b6.f;
import c2.p;
import c5.c;
import com.google.android.gms.internal.measurement.b5;
import com.google.android.gms.internal.measurement.h;
import com.google.android.gms.internal.measurement.j;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.q;
import com.google.android.gms.internal.measurement.t;
import ge.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import l0.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static n A(j jVar, q qVar, f fVar, ArrayList arrayList) {
        String str = qVar.f2579v;
        if (jVar.c(str)) {
            n nVarB = jVar.b(str);
            if (nVarB instanceof h) {
                return ((h) nVarB).e(fVar, arrayList);
            }
            throw new IllegalArgumentException(e.j(str, " is not a function"));
        }
        if (!"hasOwnProperty".equals(str)) {
            throw new IllegalArgumentException(n("Object has no function ", str));
        }
        n5.a.R("hasOwnProperty", 1, arrayList);
        return jVar.c(((t) fVar.f1801x).c(fVar, (n) arrayList.get(0)).i()) ? n.f2540g : n.f2541h;
    }

    public static void a(i0 i0Var, y1.t tVar, int i) {
        i0Var.c(tVar, i, 0);
    }

    public static final void b(View view, int i) {
        i.e(view, "view");
        int iC = y.e.c(i);
        if (iC == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                if (r0.J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iC == 1) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (iC == 2) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iC != 3) {
            return;
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static int c(int i) {
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return 5;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return 6;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 7;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return 8;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return 9;
            default:
                switch (i) {
                    case 20:
                        return 10;
                    case 21:
                        return 11;
                    case 22:
                        return 12;
                    default:
                        return 0;
                }
        }
    }

    public static int d(int i, int i10, int i11, int i12) {
        return i | i10 | i11 | 128 | i12;
    }

    public static long e(p pVar) {
        byte[] bArr = (byte[]) ((c2.q) pVar).f2042b.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }

    public static /* synthetic */ int f(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return 3;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return 4;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 5;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return 6;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return 7;
            case 9:
                return 8;
            case 10:
                return 20;
            case 11:
                return 21;
            case 12:
                return 22;
            default:
                throw null;
        }
    }

    public static boolean g(int i, boolean z10) {
        int i10 = i & 7;
        if (i10 != 4) {
            return z10 && i10 == 3;
        }
        return true;
    }

    public static float h(float f, float f10, float f11, float f12) {
        return ((f - f10) * f11) + f12;
    }

    public static int i(int i, int i10, int i11) {
        return b5.v0(i) + i10 + i11;
    }

    public static int j(int i, int i10, int i11, int i12) {
        return b5.v0(i) + i10 + i11 + i12;
    }

    public static ClassCastException k(int i, ArrayList arrayList) {
        arrayList.get(i).getClass();
        return new ClassCastException();
    }

    public static ClassCastException l(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String m(int i, int i10, String str, String str2) {
        return str + i + str2 + i10;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String p(StringBuilder sb, long j4, String str) {
        sb.append(j4);
        sb.append(str);
        return sb.toString();
    }

    public static String q(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder r(int i, int i10, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i10);
        sb.append(str3);
        return sb;
    }

    public static /* synthetic */ void s(int i, String str) {
        if (i == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = i.class.getName();
            int i10 = 0;
            while (!stackTrace[i10].getClassName().equals(name)) {
                i10++;
            }
            while (stackTrace[i10].getClassName().equals(name)) {
                i10++;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            i.h(nullPointerException, i.class.getName());
            throw nullPointerException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t(c cVar) throws Exception {
        if (cVar instanceof AutoCloseable) {
            cVar.close();
            return;
        }
        if (cVar instanceof ExecutorService) {
            b.y((ExecutorService) cVar);
            return;
        }
        if (cVar instanceof TypedArray) {
            ((TypedArray) cVar).recycle();
            return;
        }
        if (cVar instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) cVar).release();
            return;
        }
        if (cVar instanceof MediaDrm) {
            ((MediaDrm) cVar).release();
        } else if (cVar instanceof DrmManagerClient) {
            ((DrmManagerClient) cVar).release();
        } else {
            if (!(cVar instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) cVar).release();
        }
    }

    public static /* synthetic */ void u(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ boolean v(Object obj) {
        return obj != null;
    }

    public static /* synthetic */ String w(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return "RIGHT";
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return "BOTTOM";
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return "BASELINE";
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return "CENTER";
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String x(int i) {
        switch (i) {
            case 1:
                return "CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN";
            case 2:
                return "CLIENT_UPLOAD_ELIGIBLE";
            case 3:
                return "MEASUREMENT_SERVICE_NOT_ENABLED";
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return "ANDROID_TOO_OLD";
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return "NON_PLAY_MODE";
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return "SDK_TOO_OLD";
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return "MISSING_JOB_SCHEDULER";
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return "NOT_ENABLED_IN_MANIFEST";
            case 9:
                return "CLIENT_FLAG_OFF";
            case 10:
                return "SERVICE_FLAG_OFF";
            case 11:
                return "PINNED_TO_SERVICE_UPLOAD";
            case 12:
                return "MISSING_SGTM_SERVER_URL";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String y(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String z(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }
}
