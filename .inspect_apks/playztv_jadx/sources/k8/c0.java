package k8;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.a9;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.g9;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.n9;
import com.google.android.gms.internal.measurement.p7;
import com.google.android.gms.internal.measurement.r7;
import com.google.android.gms.internal.measurement.r9;
import com.google.android.gms.internal.measurement.s8;
import com.google.android.gms.internal.measurement.t9;
import com.google.android.gms.internal.measurement.u8;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.y8;
import com.google.android.gms.internal.measurement.z6;
import com.google.android.material.tabs.TabLayout;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class c0 implements e0, kb.a, c6.l, s2.j, t3.k {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7106u;

    public /* synthetic */ c0(int i) {
        this.f7106u = i;
    }

    public static RectF g(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.f3477a0 || !(view instanceof u9.j)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        u9.j jVar = (u9.j) view;
        int contentWidth = jVar.getContentWidth();
        int contentHeight = jVar.getContentHeight();
        int iB = (int) j9.f0.b(jVar.getContext(), 24);
        if (contentWidth < iB) {
            contentWidth = iB;
        }
        int right = (jVar.getRight() + jVar.getLeft()) / 2;
        int bottom = (jVar.getBottom() + jVar.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    @Override // c6.b
    public boolean B(Object obj, File file, c6.i iVar) throws Throwable {
        try {
            x6.b.d(((p6.g) ((p6.b) ((e6.b0) obj).get()).f10213u.f5886b).f10228a.f596d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e10) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            return false;
        }
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f7106u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                y8.f3250v.get();
                Boolean bool = (Boolean) a9.f2890a.a();
                bool.getClass();
                return bool;
            case 1:
                y8.f3250v.get();
                Long l10 = (Long) a9.f2891b.a();
                l10.getClass();
                return l10;
            case 2:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3280q.a()).longValue());
            case 3:
                x6.f3236v.get();
                Long l11 = (Long) z6.L.a();
                l11.getClass();
                return l11;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3277n.a()).longValue());
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                x6.f3236v.get();
                return (String) z6.I.a();
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                x6.f3236v.get();
                return (String) z6.f3273j.a();
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3284u.a()).longValue());
            case 8:
                x6.f3236v.get();
                Boolean bool2 = (Boolean) z6.f3289z.a();
                bool2.getClass();
                return bool2;
            case 9:
                e9.f2961v.get();
                Boolean bool3 = (Boolean) g9.f3023b.a();
                bool3.getClass();
                return bool3;
            case 10:
                r9.f3183v.get();
                Boolean bool4 = (Boolean) t9.f3207a.a();
                bool4.getClass();
                return bool4;
            case 11:
                p7.f3153v.get();
                Boolean bool5 = (Boolean) r7.f3182b.a();
                bool5.getClass();
                return bool5;
            case 12:
                l9.f3091v.get();
                Boolean bool6 = (Boolean) n9.f3128b.a();
                bool6.getClass();
                return bool6;
            case 13:
                l9.f3091v.get();
                Boolean bool7 = (Boolean) n9.f3127a.a();
                bool7.getClass();
                return bool7;
            default:
                s8.f3191v.get();
                Boolean bool8 = (Boolean) u8.f3212a.a();
                bool8.getClass();
                return bool8;
        }
    }

    @Override // s2.j
    public void b() {
        synchronized (t2.b.f12067a) {
            Object obj = t2.b.f12068b;
            synchronized (obj) {
                if (t2.b.f12069c) {
                    return;
                }
                long jA = t2.b.a();
                synchronized (obj) {
                    SystemClock.elapsedRealtime();
                    t2.b.f12070d = jA;
                    t2.b.f12069c = true;
                }
            }
        }
    }

    @Override // t3.k
    public boolean d(p1.q qVar) {
        return false;
    }

    @Override // t3.k
    public int e(p1.q qVar) {
        return 1;
    }

    @Override // t3.k
    public t3.m f(p1.q qVar) {
        throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
    }

    public float h(float f, float f4) {
        return 1.0f;
    }

    public void i(p2.c cVar, float f) {
        r.a aVar = (r.a) ((Drawable) cVar.f10130v);
        CardView cardView = (CardView) cVar.f10131w;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != aVar.f11201e || aVar.f != useCompatPadding || aVar.f11202g != preventCornerOverlap) {
            aVar.f11201e = f;
            aVar.f = useCompatPadding;
            aVar.f11202g = preventCornerOverlap;
            aVar.b(null);
            aVar.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            cVar.v(0, 0, 0, 0);
            return;
        }
        r.a aVar2 = (r.a) ((Drawable) cVar.f10130v);
        float f4 = aVar2.f11201e;
        float f10 = aVar2.f11197a;
        int iCeil = (int) Math.ceil(r.b.a(f4, f10, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(r.b.b(f4, f10, cardView.getPreventCornerOverlap()));
        cVar.v(iCeil, iCeil2, iCeil, iCeil2);
    }

    public void j(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF rectFG = g(tabLayout, view);
        RectF rectFG2 = g(tabLayout, view2);
        drawable.setBounds(q8.a.c(f, (int) rectFG.left, (int) rectFG2.left), drawable.getBounds().top, q8.a.c(f, (int) rectFG.right, (int) rectFG2.right), drawable.getBounds().bottom);
    }

    @Override // c6.l
    public int k(c6.i iVar) {
        return 1;
    }

    @Override // s2.j
    public void c() {
    }
}
