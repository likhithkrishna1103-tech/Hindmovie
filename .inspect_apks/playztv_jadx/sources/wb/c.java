package wb;

import a2.g1;
import aa.l0;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.emoji2.text.l;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.z;
import androidx.fragment.app.z0;
import b9.h;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.playz.tv.activities.MainActivity;
import gc.j;
import h.b0;
import i0.d;
import i4.a0;
import j9.t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k8.g2;
import k8.g4;
import k8.k1;
import k8.u0;
import k8.x3;
import l6.k;
import m.c0;
import m.i;
import m.v;
import n.n;
import n2.f;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p1.n0;
import q0.o0;
import q0.o1;
import q0.p;
import q0.r1;
import s1.u;
import s2.o;
import t3.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements l, m0.b, h, id.l, m, e7.b, y6.a, a0, v, p, g4, u0, k, i, n, o {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile c f14086w;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f14087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f14088v;

    public /* synthetic */ c(int i, Object obj) {
        this.f14087u = i;
        this.f14088v = obj;
    }

    @Override // q0.p
    public r1 C(View view, r1 r1Var) {
        NavigationView navigationView = (NavigationView) this.f14088v;
        if (navigationView.f6908v == null) {
            navigationView.f6908v = new Rect();
        }
        Rect rect = navigationView.f6908v;
        int iB = r1Var.b();
        o1 o1Var = r1Var.f10492a;
        rect.set(iB, r1Var.d(), r1Var.c(), r1Var.a());
        t tVar = navigationView.C;
        tVar.getClass();
        int iD = r1Var.d();
        if (tVar.T != iD) {
            tVar.T = iD;
            int i = (tVar.f6902v.getChildCount() <= 0 && tVar.R) ? tVar.T : 0;
            NavigationMenuView navigationMenuView = tVar.f6901u;
            navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = tVar.f6901u;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, r1Var.a());
        o0.b(tVar.f6902v, r1Var);
        navigationView.setWillNotDraw(o1Var.k().equals(d.f6160e) || navigationView.f6907u == null);
        navigationView.postInvalidateOnAnimation();
        return o1Var.c();
    }

    @Override // id.l
    public boolean D() {
        return ((bd.c) this.f14088v).A;
    }

    @Override // androidx.emoji2.text.l
    public void a(cf.d dVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer", 0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new g1(this, dVar, threadPoolExecutor, 2));
    }

    @Override // k8.g4
    public void b(String str, String str2, Bundle bundle) {
        g2 g2Var = (g2) this.f14088v;
        k1 k1Var = (k1) g2Var.f2454v;
        if (!TextUtils.isEmpty(str)) {
            k1Var.getClass();
            throw new IllegalStateException("Unexpected call on client side");
        }
        k1Var.H.getClass();
        g2Var.C1("auto", "_err", bundle, true, true, System.currentTimeMillis());
    }

    @Override // m.v
    public void c(m.k kVar, boolean z2) {
        switch (this.f14087u) {
            case 15:
                ((b0) this.f14088v).r(kVar);
                break;
            default:
                if (kVar instanceof c0) {
                    ((c0) kVar).f8181z.k().c(false);
                }
                v vVar = ((n.k) this.f14088v).f8425y;
                if (vVar != null) {
                    vVar.c(kVar, z2);
                }
                break;
        }
    }

    @Override // b9.h
    public void d(ArrayList arrayList) {
        ChipGroup chipGroup = (ChipGroup) this.f14088v;
        if (chipGroup.B.f6834d) {
            chipGroup.getCheckedChipId();
            throw null;
        }
    }

    @Override // s2.o
    public Object e(Uri uri, v1.k kVar) throws n0 {
        try {
            XmlPullParser xmlPullParserNewPullParser = ((XmlPullParserFactory) this.f14088v).newPullParser();
            xmlPullParserNewPullParser.setInput(kVar, null);
            return (n2.c) new f(uri.toString()).e(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e10) {
            throw n0.b(null, e10);
        }
    }

    public Set f() {
        Set setUnmodifiableSet;
        synchronized (((HashSet) this.f14088v)) {
            setUnmodifiableSet = Collections.unmodifiableSet((HashSet) this.f14088v);
        }
        return setUnmodifiableSet;
    }

    @Override // m.i
    public boolean g(m.k kVar, MenuItem menuItem) {
        l9.k kVar2 = ((BottomNavigationView) this.f14088v).f8058y;
        if (kVar2 != null) {
            MainActivity mainActivity = ((hc.d) kVar2).f6033v;
            if (mainActivity.f3606j0 != null) {
                mainActivity.A();
            }
            if (mainActivity.f3607k0 != null) {
                mainActivity.B();
            }
            mainActivity.z();
            int itemId = menuItem.getItemId();
            if (itemId == j.navigation_sports) {
                mainActivity.f3611p0 = "Sports";
                if (mainActivity.f3601e0 == null) {
                    vc.a aVar = (vc.a) new a7.b(mainActivity).t(vc.a.class, "sports");
                    aVar.f13485e = true;
                    aVar.f13484d = new hc.d(mainActivity, 3);
                    mainActivity.f3601e0 = nc.h.U("sports");
                    androidx.fragment.app.n0 n0VarO = mainActivity.o();
                    androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                    aVarI.e(j.sports_fragment_container, mainActivity.f3601e0, null, 1);
                    aVarI.d(false);
                }
                mainActivity.f3618w0 = false;
                mainActivity.f3617v0 = false;
                mainActivity.f3613r0 = false;
                mainActivity.f3616u0 = true;
                ((FragmentContainerView) mainActivity.Y.f2547d).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.f2544a).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.f2545b).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.f2548e).setVisibility(8);
                if (!mainActivity.f3614s0 || mainActivity.f3615t0) {
                    mainActivity.f3615t0 = false;
                    mainActivity.f3614s0 = false;
                    mainActivity.f3598b0 = mainActivity.f3601e0;
                    ((FragmentContainerView) mainActivity.Y.f2551j).setVisibility(0);
                    ((FragmentContainerView) mainActivity.Y.i).setVisibility(8);
                    mainActivity.y();
                } else {
                    mainActivity.D();
                    mainActivity.f3615t0 = true;
                    nc.m mVar = mainActivity.f3603g0;
                    mainActivity.f3598b0 = mVar;
                    mainActivity.V.B = mVar.f8946v0;
                    ((Toolbar) mainActivity.X.f5868w).setTitle(mainActivity.f3610o0);
                    ((FragmentContainerView) mainActivity.Y.f2551j).setVisibility(8);
                    ((FragmentContainerView) mainActivity.Y.i).setVisibility(0);
                }
                if (mainActivity.A0 == 0) {
                    mainActivity.f3601e0.S("");
                }
            } else if (itemId == j.navigation_categories) {
                mainActivity.f3611p0 = "Categories";
                if (mainActivity.f3600d0 == null) {
                    ((vc.a) new a7.b(mainActivity).t(vc.a.class, "categories")).f13484d = new hc.d(mainActivity, 2);
                    mainActivity.f3600d0 = nc.h.U("categories");
                    androidx.fragment.app.n0 n0VarO2 = mainActivity.o();
                    androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                    aVarI2.e(j.categories_fragment_container, mainActivity.f3600d0, null, 1);
                    aVarI2.d(false);
                }
                mainActivity.f3618w0 = false;
                mainActivity.f3617v0 = false;
                mainActivity.f3616u0 = false;
                mainActivity.f3615t0 = false;
                ((FragmentContainerView) mainActivity.Y.f2547d).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.f2551j).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.i).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.f2548e).setVisibility(8);
                if (!mainActivity.f3612q0 || mainActivity.f3613r0) {
                    mainActivity.f3613r0 = false;
                    mainActivity.f3612q0 = false;
                    mainActivity.f3598b0 = mainActivity.f3600d0;
                    ((FragmentContainerView) mainActivity.Y.f2544a).setVisibility(0);
                    ((FragmentContainerView) mainActivity.Y.f2545b).setVisibility(8);
                    mainActivity.y();
                } else {
                    mainActivity.D();
                    mainActivity.f3613r0 = true;
                    nc.m mVar2 = mainActivity.f3602f0;
                    mainActivity.f3598b0 = mVar2;
                    mainActivity.V.B = mVar2.f8946v0;
                    ((Toolbar) mainActivity.X.f5868w).setTitle(mainActivity.f3609n0);
                    ((FragmentContainerView) mainActivity.Y.f2544a).setVisibility(8);
                    ((FragmentContainerView) mainActivity.Y.f2545b).setVisibility(0);
                }
                if (mainActivity.A0 == 0) {
                    mainActivity.f3600d0.S("");
                }
            } else {
                mainActivity.f3611p0 = mainActivity.f3608m0;
                mainActivity.C();
            }
            ((Toolbar) mainActivity.X.f5868w).setTitle(mainActivity.f3611p0);
        }
        return false;
    }

    @Override // md.a
    public Object get() {
        switch (this.f14087u) {
            case 10:
                return new a7.b((Context) ((e7.c) this.f14088v).f4586u, new k8.b0(17), new k8.a0(17), 11);
            default:
                return new j7.i(Integer.valueOf(j7.i.f6827x).intValue(), (Context) ((md.a) this.f14088v).get(), "com.google.android.datatransport.events");
        }
    }

    @Override // t3.m
    public /* synthetic */ t3.d h(byte[] bArr, int i, int i10) {
        return e6.j.a(this, bArr, i10);
    }

    public void i() {
        ((z) this.f14088v).f1425x.N();
    }

    @Override // k8.u0
    public void k(String str, int i, Throwable th, byte[] bArr, Map map) {
        ((x3) this.f14088v).J(str, i, th, bArr, map);
    }

    @Override // l6.k
    public short l() throws l6.j {
        ByteBuffer byteBuffer = (ByteBuffer) this.f14088v;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new l6.j();
    }

    @Override // t3.m
    public int m() {
        return 2;
    }

    @Override // t3.m
    public void n(byte[] bArr, int i, int i10, t3.l lVar, s1.h hVar) {
        r1.b bVarA;
        u uVar = (u) this.f14088v;
        uVar.H(i + i10, bArr);
        uVar.J(i);
        ArrayList arrayList = new ArrayList();
        while (uVar.a() > 0) {
            s1.d.a("Incomplete Mp4Webvtt Top Level box header found.", uVar.a() >= 8);
            int iJ = uVar.j();
            if (uVar.j() == 1987343459) {
                int i11 = iJ - 8;
                CharSequence charSequenceF = null;
                r1.a aVarA = null;
                while (i11 > 0) {
                    s1.d.a("Incomplete vtt cue box header found.", i11 >= 8);
                    int iJ2 = uVar.j();
                    int iJ3 = uVar.j();
                    int i12 = iJ2 - 8;
                    byte[] bArr2 = uVar.f11709a;
                    int i13 = uVar.f11710b;
                    int i14 = s1.b0.f11647a;
                    String str = new String(bArr2, i13, i12, StandardCharsets.UTF_8);
                    uVar.K(i12);
                    i11 = (i11 - 8) - i12;
                    if (iJ3 == 1937011815) {
                        c4.h hVar2 = new c4.h();
                        c4.i.e(str, hVar2);
                        aVarA = hVar2.a();
                    } else if (iJ3 == 1885436268) {
                        charSequenceF = c4.i.f(null, str.trim(), Collections.EMPTY_LIST);
                    }
                }
                if (charSequenceF == null) {
                    charSequenceF = "";
                }
                if (aVarA != null) {
                    aVarA.f11229a = charSequenceF;
                    aVarA.f11230b = null;
                    bVarA = aVarA.a();
                } else {
                    Pattern pattern = c4.i.f2500a;
                    c4.h hVar3 = new c4.h();
                    hVar3.f2493c = charSequenceF;
                    bVarA = hVar3.a().a();
                }
                arrayList.add(bVarA);
            } else {
                uVar.K(iJ - 8);
            }
        }
        hVar.accept(new t3.a(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    @Override // m0.b
    public void onCancel() {
        ((z0) this.f14088v).a();
    }

    @Override // y6.a
    public Object r() {
        l0 l0Var = (l0) this.f14088v;
        return new e6.k((q7.h) l0Var.f706w, (kc.b) l0Var.f707x);
    }

    @Override // l6.k
    public long skip(long j5) {
        ByteBuffer byteBuffer = (ByteBuffer) this.f14088v;
        int iMin = (int) Math.min(byteBuffer.remaining(), j5);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    @Override // l6.k
    public int v() {
        return (l() << 8) | l();
    }

    @Override // m.v
    public boolean x(m.k kVar) {
        switch (this.f14087u) {
            case 15:
                Window.Callback callback = ((b0) this.f14088v).F.getCallback();
                if (callback == null) {
                    return true;
                }
                callback.onMenuOpened(108, kVar);
                return true;
            default:
                n.k kVar2 = (n.k) this.f14088v;
                if (kVar == kVar2.f8423w) {
                    return false;
                }
                kVar2.S = ((c0) kVar).A.f8230a;
                v vVar = kVar2.f8425y;
                if (vVar != null) {
                    return vVar.x(kVar);
                }
                return false;
        }
    }

    @Override // l6.k
    public int z(int i, byte[] bArr) {
        ByteBuffer byteBuffer = (ByteBuffer) this.f14088v;
        int iMin = Math.min(i, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    public c(u5.d dVar) {
        this.f14087u = 8;
        this.f14088v = Collections.unmodifiableMap(new HashMap((HashMap) dVar.f12784v));
    }

    public c(int i) {
        this.f14087u = i;
        switch (i) {
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f14088v = new u();
                return;
            case 17:
                return;
            case 18:
                this.f14088v = new i6.o(500L);
                return;
            case 28:
                try {
                    this.f14088v = XmlPullParserFactory.newInstance();
                    return;
                } catch (XmlPullParserException e10) {
                    throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
                }
            default:
                this.f14088v = new HashSet();
                return;
        }
    }

    public c(Context context) {
        this.f14087u = 1;
        this.f14088v = context.getApplicationContext();
    }

    public c(ByteBuffer byteBuffer) {
        this.f14087u = 24;
        this.f14088v = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    @Override // t3.m
    public /* synthetic */ void reset() {
    }

    @Override // m.i
    public void s(m.k kVar) {
    }
}
