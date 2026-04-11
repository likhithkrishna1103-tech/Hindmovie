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
import app.cricfy.tv.activities.WebActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import m4.f0;
import m4.j0;
import v1.l1;
import v1.w0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2873v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f2874w;

    public /* synthetic */ n(int i, Object obj) {
        this.f2873v = i;
        this.f2874w = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecyclerView recyclerView;
        v4.z adapter;
        int iJ;
        int i = this.f2873v;
        Object obj = this.f2874w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) obj).V();
                throw null;
            case 1:
                m4.q.a((m4.q) obj);
                return;
            case 2:
                m4.q qVar = ((m4.e) obj).f8172g;
                w0 w0Var = qVar.C0;
                if (w0Var == null || !w0Var.Z(29)) {
                    return;
                }
                l1 l1VarE0 = qVar.C0.E0();
                w0 w0Var2 = qVar.C0;
                int i10 = y1.a0.f14551a;
                w0Var2.e0(l1VarE0.a().d(1).i(1, false).b());
                ((String[]) qVar.A.f)[1] = qVar.getResources().getString(j0.exo_track_selection_auto);
                qVar.F.dismiss();
                return;
            case 3:
                m4.k kVar = (m4.k) obj;
                m4.q qVar2 = kVar.f8182x;
                int i11 = -1;
                if (kVar.f13403s != null && (recyclerView = kVar.f13402r) != null && (adapter = recyclerView.getAdapter()) != null && (iJ = kVar.f13402r.J(kVar)) != -1 && kVar.f13403s == adapter) {
                    i11 = iJ;
                }
                View view2 = qVar2.U;
                if (i11 == 0) {
                    m4.i iVar = qVar2.B;
                    view2.getClass();
                    qVar2.e(iVar, view2);
                    return;
                } else {
                    if (i11 != 1) {
                        qVar2.F.dismiss();
                        return;
                    }
                    m4.e eVar = qVar2.D;
                    view2.getClass();
                    qVar2.e(eVar, view2);
                    return;
                }
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                m4.q qVar3 = ((m4.e) obj).f8172g;
                w0 w0Var3 = qVar3.C0;
                if (w0Var3 == null || !w0Var3.Z(29)) {
                    return;
                }
                qVar3.C0.e0(qVar3.C0.E0().a().d(3).g().b());
                qVar3.F.dismiss();
                return;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                m4.v vVar = (m4.v) obj;
                vVar.g();
                if (view.getId() == f0.exo_overflow_show) {
                    vVar.f8283q.start();
                    return;
                } else {
                    if (view.getId() == f0.exo_overflow_hide) {
                        vVar.f8284r.start();
                        return;
                    }
                    return;
                }
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                pa.e eVar2 = (pa.e) obj;
                EditText editText = eVar2.i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                eVar2.p();
                return;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                ((pa.l) obj).t();
                return;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                pa.w wVar = (pa.w) obj;
                EditText editText2 = wVar.f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = wVar.f;
                if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    wVar.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    wVar.f.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    wVar.f.setSelection(selectionEnd);
                }
                wVar.p();
                return;
            case 9:
                ((WebActivity) obj).Y.a();
                return;
            case 10:
                s5.i iVar2 = ((s5.g) obj).f11489x;
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(iVar2.f11499h));
                    iVar2.f11497e.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException e9) {
                    Toast.makeText(iVar2.f11497e, e9.getMessage(), 0).show();
                    return;
                }
            case 11:
                ((v5.h) obj).R(false, false);
                return;
            case 12:
                v5.i iVar3 = (v5.i) obj;
                iVar3.getClass();
                try {
                    iVar3.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(iVar3.f13431y)));
                    return;
                } catch (ActivityNotFoundException e10) {
                    Toast.makeText(iVar3.getContext(), e10.getMessage(), 0).show();
                    return;
                }
            case 13:
                ((h.h) obj).dismiss();
                return;
            case 14:
                x5.i iVar4 = (x5.i) obj;
                h.j jVarJ = iVar4.J();
                ArrayList arrayList = iVar4.f14351x0;
                x5.g gVar = new x5.g(iVar4);
                v5.d dVar = new v5.d();
                dVar.J0 = arrayList;
                dVar.K0 = gVar;
                dVar.U(jVarJ.o(), "ChooseDialog");
                return;
            case 15:
                x5.k kVar2 = (x5.k) obj;
                String str = kVar2.H0.f;
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    kVar2.Q(intent2);
                    return;
                } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException e11) {
                    Toast.makeText(kVar2.j(), e11.getMessage(), 0).show();
                    return;
                }
            case 16:
                x5.p pVar = (x5.p) obj;
                new h.g(pVar.K()).setTitle("Delete All Notifications").a("Are you sure, you want to delete all notifications?").b("CANCEl").c("DELETE", new a6.c(5, pVar)).d();
                return;
            default:
                x5.r rVar = (x5.r) obj;
                Context contextJ = rVar.j();
                b6.f fVar = new b6.f(contextJ, (FloatingActionButton) rVar.f14375s0.f3673x);
                new m.h(contextJ).inflate(q5.m.menu_playlist, (n.k) fVar.f1800w);
                fVar.f1803z = new x5.q(rVar);
                n.u uVar = (n.u) fVar.f1802y;
                if (uVar.b()) {
                    return;
                }
                if (uVar.f8584e == null) {
                    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                }
                uVar.d(0, 0, false, false);
                return;
        }
    }
}
