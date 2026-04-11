package q0;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f, q4.f1, ra.b, sa.a, t7.c, o8.g, i, z4.d, x8.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10435u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10436v;

    public /* synthetic */ e(int i, Object obj) {
        this.f10435u = i;
        this.f10436v = obj;
    }

    public static String o(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // q0.f
    public ClipData a() {
        return ((ContentInfo) this.f10436v).getClip();
    }

    @Override // q4.f1
    public int b() {
        q4.h0 h0Var = (q4.h0) this.f10436v;
        return h0Var.f10829o - h0Var.C();
    }

    @Override // t7.c
    public void c(q7.b bVar) {
        ((r7.d) this.f10436v).c(bVar);
    }

    @Override // z4.d
    public void d(z4.c cVar) {
        u4.e eVar = (u4.e) this.f10436v;
        int length = eVar.f12768x.length;
        for (int i = 1; i < length; i++) {
            int i10 = eVar.f12768x[i];
            if (i10 == 1) {
                cVar.N(i, eVar.f12769y[i]);
            } else if (i10 == 2) {
                cVar.z(i, eVar.f12770z[i]);
            } else if (i10 == 3) {
                String str = eVar.A[i];
                be.h.b(str);
                cVar.V(str, i);
            } else if (i10 == 4) {
                byte[] bArr = eVar.B[i];
                be.h.b(bArr);
                cVar.U(i, bArr);
            } else if (i10 == 5) {
                cVar.b(i);
            }
        }
    }

    @Override // sa.a
    public void e(ta.o oVar) {
        this.f10436v = oVar;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    @Override // q0.f
    public int f() {
        return ((ContentInfo) this.f10436v).getFlags();
    }

    @Override // q4.f1
    public int g(View view) {
        return (view.getTop() - ((q4.i0) view.getLayoutParams()).f10832b.top) - ((ViewGroup.MarginLayoutParams) ((q4.i0) view.getLayoutParams())).topMargin;
    }

    @Override // q0.f
    public ContentInfo h() {
        return (ContentInfo) this.f10436v;
    }

    @Override // q0.i
    public boolean i(float f) {
        if (f == 0.0f) {
            return false;
        }
        s();
        ((NestedScrollView) this.f10436v).j((int) f);
        return true;
    }

    @Override // q0.f
    public int j() {
        return ((ContentInfo) this.f10436v).getSource();
    }

    @Override // q4.f1
    public View k(int i) {
        return ((q4.h0) this.f10436v).u(i);
    }

    @Override // ra.b
    public void l(String str, Bundle bundle) {
        ta.o oVar = (ta.o) this.f10436v;
        if (oVar != null) {
            try {
                String str2 = "$A$:" + o(str, bundle);
                ta.q qVar = oVar.f12399a;
                qVar.f12416o.f12823a.a(new ta.p(qVar, System.currentTimeMillis() - qVar.f12407d, str2, 0));
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    public void m(int i) {
        RecyclerView recyclerView = (RecyclerView) this.f10436v;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            RecyclerView.M(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }

    @Override // q4.f1
    public int n() {
        return ((q4.h0) this.f10436v).F();
    }

    @Override // q4.f1
    public int p(View view) {
        return view.getBottom() + ((q4.i0) view.getLayoutParams()).f10832b.bottom + ((ViewGroup.MarginLayoutParams) ((q4.i0) view.getLayoutParams())).bottomMargin;
    }

    @Override // q0.i
    public float q() {
        return -((NestedScrollView) this.f10436v).getVerticalScrollFactorCompat();
    }

    @Override // o8.g
    public o8.o r(Object obj) {
        bb.c cVar = (bb.c) obj;
        pb.c cVar2 = (pb.c) this.f10436v;
        if (cVar == null) {
            Log.w("FirebaseCrashlytics", "Received null app settings at app startup. Cannot send cached reports", null);
            return wa.t1.k(null);
        }
        ta.m mVar = (ta.m) cVar2.f10311w;
        ta.m.a(mVar);
        mVar.f12391m.u(null, mVar.f12385e.f12823a);
        mVar.f12395q.c(null);
        return wa.t1.k(null);
    }

    @Override // q0.i
    public void s() {
        ((NestedScrollView) this.f10436v).f998x.abortAnimation();
    }

    public String toString() {
        switch (this.f10435u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "ContentInfoCompat{" + ((ContentInfo) this.f10436v) + "}";
            default:
                return super.toString();
        }
    }

    @Override // z4.d
    public String v() {
        return ((u4.e) this.f10436v).f12773v;
    }

    public e(int i) {
        this.f10435u = i;
        switch (i) {
            case 14:
                this.f10436v = new s1.u(10);
                break;
            default:
                be.h.e(TimeUnit.MINUTES, "timeUnit");
                this.f10436v = new k8.t0(xe.c.i);
                break;
        }
    }

    public e(View view) {
        this.f10435u = 1;
        if (Build.VERSION.SDK_INT >= 30) {
            w wVar = new w(view);
            wVar.f10509v = view;
            this.f10436v = wVar;
            return;
        }
        this.f10436v = new o4.c(view);
    }

    public e(ContentInfo contentInfo) {
        this.f10435u = 0;
        contentInfo.getClass();
        this.f10436v = c2.v.l(contentInfo);
    }
}
