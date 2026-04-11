package com.google.android.material.datepicker;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.playz.tv.activities.WebActivity;
import i4.h0;
import i4.l0;
import p1.l1;
import p1.w0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f3418u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f3419v;

    public /* synthetic */ n(int i, Object obj) {
        this.f3418u = i;
        this.f3419v = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecyclerView recyclerView;
        q4.z adapter;
        int iJ;
        int i = this.f3418u;
        Object obj = this.f3419v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((o) obj).S();
                throw null;
            case 1:
                ((WebActivity) obj).X.a();
                return;
            case 2:
                i4.s.a((i4.s) obj);
                return;
            case 3:
                i4.s sVar = ((i4.g) obj).f6225g;
                w0 w0Var = sVar.B0;
                if (w0Var == null || !w0Var.e0(29)) {
                    return;
                }
                l1 l1VarE0 = sVar.B0.E0();
                w0 w0Var2 = sVar.B0;
                int i10 = b0.f11647a;
                w0Var2.b0(l1VarE0.a().d(1).i(1, false).b());
                ((String[]) sVar.f6288z.f)[1] = sVar.getResources().getString(l0.exo_track_selection_auto);
                sVar.E.dismiss();
                return;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                i4.m mVar = (i4.m) obj;
                i4.s sVar2 = mVar.f6235x;
                int i11 = -1;
                if (mVar.f10978s != null && (recyclerView = mVar.f10977r) != null && (adapter = recyclerView.getAdapter()) != null && (iJ = mVar.f10977r.J(mVar)) != -1 && mVar.f10978s == adapter) {
                    i11 = iJ;
                }
                View view2 = sVar2.T;
                if (i11 == 0) {
                    i4.k kVar = sVar2.A;
                    view2.getClass();
                    sVar2.e(kVar, view2);
                    return;
                } else {
                    if (i11 != 1) {
                        sVar2.E.dismiss();
                        return;
                    }
                    i4.g gVar = sVar2.C;
                    view2.getClass();
                    sVar2.e(gVar, view2);
                    return;
                }
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                i4.s sVar3 = ((i4.g) obj).f6225g;
                w0 w0Var3 = sVar3.B0;
                if (w0Var3 == null || !w0Var3.e0(29)) {
                    return;
                }
                sVar3.B0.b0(sVar3.B0.E0().a().d(3).g().b());
                sVar3.E.dismiss();
                return;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                i4.x xVar = (i4.x) obj;
                xVar.g();
                if (view.getId() == h0.exo_overflow_show) {
                    xVar.f6339q.start();
                    return;
                } else {
                    if (view.getId() == h0.exo_overflow_hide) {
                        xVar.f6340r.start();
                        return;
                    }
                    return;
                }
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                ic.k kVar2 = ((ic.i) obj).f6514x;
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(kVar2.f6524h));
                    kVar2.f6522e.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException e10) {
                    Toast.makeText(kVar2.f6522e, e10.getMessage(), 0).show();
                    return;
                }
            case 8:
                ((lc.h) obj).P(false, false);
                return;
            case 9:
                nc.m mVar2 = (nc.m) obj;
                new lc.e(mVar2.f8947w0, mVar2.B0, new nc.i(mVar2)).R(mVar2.G().o(), "ChooseDialog");
                return;
            case 10:
                nc.o oVar = (nc.o) obj;
                String str = oVar.G0.f;
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    oVar.O(intent2);
                    return;
                } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException e11) {
                    Toast.makeText(oVar.j(), e11.getMessage(), 0).show();
                    return;
                }
            case 11:
                nc.u uVar = (nc.u) obj;
                Context contextJ = uVar.j();
                ub.o oVar2 = new ub.o(contextJ, (FloatingActionButton) uVar.f8971r0.f14946v);
                new l.h(contextJ).inflate(gc.l.menu_playlist, (m.k) oVar2.f12868v);
                oVar2.f12871y = new nc.t(uVar);
                m.u uVar2 = (m.u) oVar2.f12870x;
                if (uVar2.b()) {
                    return;
                }
                if (uVar2.f8270e == null) {
                    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                }
                uVar2.d(0, 0, false, false);
                return;
            case 12:
                v9.d dVar = (v9.d) obj;
                EditText editText = dVar.i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                dVar.p();
                return;
            case 13:
                ((v9.j) obj).t();
                return;
            default:
                v9.t tVar = (v9.t) obj;
                EditText editText2 = tVar.f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = tVar.f;
                if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    tVar.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    tVar.f.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    tVar.f.setSelection(selectionEnd);
                }
                tVar.p();
                return;
        }
    }
}
