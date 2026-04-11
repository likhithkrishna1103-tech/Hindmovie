package androidx.emoji2.text;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f880v;

    public /* synthetic */ t(String str, boolean z10) {
        this.f880v = str;
    }

    public static t c(y1.t tVar) {
        String str;
        tVar.K(2);
        int iX = tVar.x();
        int i = iX >> 1;
        int iX2 = ((tVar.x() >> 3) & 31) | ((iX & 1) << 5);
        if (i == 4 || i == 5 || i == 7 || i == 8) {
            str = "dvhe";
        } else if (i == 9) {
            str = "dvav";
        } else {
            if (i != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sbB = y.e.b(str);
        sbB.append(i < 10 ? ".0" : ".");
        sbB.append(i);
        sbB.append(iX2 < 10 ? ".0" : ".");
        sbB.append(iX2);
        return new t(sbB.toString(), false);
    }

    public void a(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f880v);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
        } catch (IOException e9) {
            throw new AssertionError(e9);
        }
    }

    public String b(List list) {
        Iterator it = list.iterator();
        StringBuilder sb = new StringBuilder();
        a(sb, it);
        return sb.toString();
    }

    @Override // androidx.emoji2.text.s
    public boolean f(CharSequence charSequence, int i, int i10, c0 c0Var) {
        if (!TextUtils.equals(charSequence.subSequence(i, i10), this.f880v)) {
            return true;
        }
        c0Var.f842c = (c0Var.f842c & 3) | 4;
        return false;
    }

    public t(String str) {
        str.getClass();
        this.f880v = str;
    }

    @Override // androidx.emoji2.text.s
    public Object d() {
        return this;
    }
}
