package com.phisher98.donation;

/* JADX INFO: compiled from: DonationData.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000eHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J³\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001J\u0014\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010.\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u001a¨\u0006G"}, d2 = {"Lcom/phisher98/donation/DonationConfig;", "", "enabled", "", "extensionName", "", "month", "title", "description", "currency", "targetAmount", "", "currentAmount", "supportersCount", "", "primaryDonateUrl", "primaryButtonText", "secondaryDonateUrl", "secondaryButtonText", "adSupportUrl", "adSupportButtonText", "cooldownHours", "cooldownScope", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getEnabled", "()Z", "getExtensionName", "()Ljava/lang/String;", "getMonth", "getTitle", "getDescription", "getCurrency", "getTargetAmount", "()D", "getCurrentAmount", "getSupportersCount", "()I", "getPrimaryDonateUrl", "getPrimaryButtonText", "getSecondaryDonateUrl", "getSecondaryButtonText", "getAdSupportUrl", "getAdSupportButtonText", "getCooldownHours", "getCooldownScope", "progressPercentage", "getProgressPercentage", "isGoalAchieved", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class DonationConfig {

    @org.jetbrains.annotations.NotNull
    private final java.lang.String adSupportButtonText;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String adSupportUrl;
    private final int cooldownHours;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String cooldownScope;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String currency;
    private final double currentAmount;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String description;
    private final boolean enabled;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String extensionName;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String month;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String primaryButtonText;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String primaryDonateUrl;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String secondaryButtonText;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String secondaryDonateUrl;
    private final int supportersCount;
    private final double targetAmount;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String title;

    public DonationConfig() {
            r22 = this;
            r20 = 131071(0x1ffff, float:1.8367E-40)
            r21 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r0 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
    }

    public DonationConfig(boolean r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull java.lang.String r22, double r23, double r25, int r27, @org.jetbrains.annotations.NotNull java.lang.String r28, @org.jetbrains.annotations.NotNull java.lang.String r29, @org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.NotNull java.lang.String r31, @org.jetbrains.annotations.NotNull java.lang.String r32, @org.jetbrains.annotations.NotNull java.lang.String r33, int r34, @org.jetbrains.annotations.NotNull java.lang.String r35) {
            r16 = this;
            r0 = r16
            r0.<init>()
            r1 = r17
            r0.enabled = r1
            r2 = r18
            r0.extensionName = r2
            r3 = r19
            r0.month = r3
            r4 = r20
            r0.title = r4
            r5 = r21
            r0.description = r5
            r6 = r22
            r0.currency = r6
            r7 = r23
            r0.targetAmount = r7
            r9 = r25
            r0.currentAmount = r9
            r11 = r27
            r0.supportersCount = r11
            r12 = r28
            r0.primaryDonateUrl = r12
            r13 = r29
            r0.primaryButtonText = r13
            r14 = r30
            r0.secondaryDonateUrl = r14
            r15 = r31
            r0.secondaryButtonText = r15
            r1 = r32
            r0.adSupportUrl = r1
            r1 = r33
            r0.adSupportButtonText = r1
            r1 = r34
            r0.cooldownHours = r1
            r1 = r35
            r0.cooldownScope = r1
            return
    }

    public /* synthetic */ DonationConfig(boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, double r25, double r27, int r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, java.lang.String r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
            r18 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L8
            r1 = 1
            goto La
        L8:
            r1 = r19
        La:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L12
            r2 = r3
            goto L14
        L12:
            r2 = r20
        L14:
            r4 = r0 & 4
            if (r4 == 0) goto L1b
            java.lang.String r4 = "Monthly Goal"
            goto L1d
        L1b:
            r4 = r21
        L1d:
            r5 = r0 & 8
            if (r5 == 0) goto L24
            java.lang.String r5 = "Help Keep This Extension Alive"
            goto L26
        L24:
            r5 = r22
        L26:
            r6 = r0 & 16
            if (r6 == 0) goto L2c
            r6 = r3
            goto L2e
        L2c:
            r6 = r23
        L2e:
            r7 = r0 & 32
            if (r7 == 0) goto L35
            java.lang.String r7 = "$"
            goto L37
        L35:
            r7 = r24
        L37:
            r8 = r0 & 64
            if (r8 == 0) goto L3e
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            goto L40
        L3e:
            r8 = r25
        L40:
            r10 = r0 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L47
            r10 = 0
            goto L49
        L47:
            r10 = r27
        L49:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L4f
            r12 = 0
            goto L51
        L4f:
            r12 = r29
        L51:
            r13 = r0 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L58
            java.lang.String r13 = "https://buymeacoffee.com/phisher98"
            goto L5a
        L58:
            r13 = r30
        L5a:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L61
            java.lang.String r14 = "☕ Keep It Alive"
            goto L63
        L61:
            r14 = r31
        L63:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L68
            goto L6a
        L68:
            r3 = r32
        L6a:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L71
            java.lang.String r15 = "⚡ Donate via UPI / Other"
            goto L73
        L71:
            r15 = r33
        L73:
            r19 = r1
            r1 = r0 & 8192(0x2000, float:1.148E-41)
            if (r1 == 0) goto L7c
            java.lang.String r1 = "https://omg10.com/4/11733824"
            goto L7e
        L7c:
            r1 = r34
        L7e:
            r20 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L87
            java.lang.String r1 = "🎬 Can't donate? Watch an Ad to Support ↗"
            goto L89
        L87:
            r1 = r35
        L89:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L93
            r16 = 24
            goto L95
        L93:
            r16 = r36
        L95:
            r17 = 65536(0x10000, float:9.1835E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L9e
            java.lang.String r0 = "global"
            goto La0
        L9e:
            r0 = r37
        La0:
            r35 = r20
            r38 = r0
            r36 = r1
            r21 = r2
            r33 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r30 = r12
            r31 = r13
            r32 = r14
            r34 = r15
            r37 = r16
            r20 = r19
            r19 = r18
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
    }

    public static /* synthetic */ com.phisher98.donation.DonationConfig copy$default(com.phisher98.donation.DonationConfig r17, boolean r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, double r24, double r26, int r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, java.lang.String r36, int r37, java.lang.Object r38) {
            r0 = r17
            r1 = r37
            r2 = r1 & 1
            if (r2 == 0) goto Lb
            boolean r2 = r0.enabled
            goto Ld
        Lb:
            r2 = r18
        Ld:
            r3 = r1 & 2
            if (r3 == 0) goto L14
            java.lang.String r3 = r0.extensionName
            goto L16
        L14:
            r3 = r19
        L16:
            r4 = r1 & 4
            if (r4 == 0) goto L1d
            java.lang.String r4 = r0.month
            goto L1f
        L1d:
            r4 = r20
        L1f:
            r5 = r1 & 8
            if (r5 == 0) goto L26
            java.lang.String r5 = r0.title
            goto L28
        L26:
            r5 = r21
        L28:
            r6 = r1 & 16
            if (r6 == 0) goto L2f
            java.lang.String r6 = r0.description
            goto L31
        L2f:
            r6 = r22
        L31:
            r7 = r1 & 32
            if (r7 == 0) goto L38
            java.lang.String r7 = r0.currency
            goto L3a
        L38:
            r7 = r23
        L3a:
            r8 = r1 & 64
            if (r8 == 0) goto L41
            double r8 = r0.targetAmount
            goto L43
        L41:
            r8 = r24
        L43:
            r10 = r1 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L4a
            double r10 = r0.currentAmount
            goto L4c
        L4a:
            r10 = r26
        L4c:
            r12 = r1 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L53
            int r12 = r0.supportersCount
            goto L55
        L53:
            r12 = r28
        L55:
            r13 = r1 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L5c
            java.lang.String r13 = r0.primaryDonateUrl
            goto L5e
        L5c:
            r13 = r29
        L5e:
            r14 = r1 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L65
            java.lang.String r14 = r0.primaryButtonText
            goto L67
        L65:
            r14 = r30
        L67:
            r15 = r1 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L6e
            java.lang.String r15 = r0.secondaryDonateUrl
            goto L70
        L6e:
            r15 = r31
        L70:
            r18 = r2
            r2 = r1 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L79
            java.lang.String r2 = r0.secondaryButtonText
            goto L7b
        L79:
            r2 = r32
        L7b:
            r19 = r2
            r2 = r1 & 8192(0x2000, float:1.148E-41)
            if (r2 == 0) goto L84
            java.lang.String r2 = r0.adSupportUrl
            goto L86
        L84:
            r2 = r33
        L86:
            r20 = r2
            r2 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L8f
            java.lang.String r2 = r0.adSupportButtonText
            goto L91
        L8f:
            r2 = r34
        L91:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r1 & r16
            if (r16 == 0) goto L9b
            int r1 = r0.cooldownHours
            goto L9d
        L9b:
            r1 = r35
        L9d:
            r16 = 65536(0x10000, float:9.1835E-41)
            r16 = r37 & r16
            if (r16 == 0) goto Lac
            r21 = r1
            java.lang.String r1 = r0.cooldownScope
            r36 = r21
            r37 = r1
            goto Lb0
        Lac:
            r37 = r36
            r36 = r1
        Lb0:
            r33 = r19
            r34 = r20
            r35 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r27 = r10
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r19 = r18
            r18 = r0
            com.phisher98.donation.DonationConfig r0 = r18.copy(r19, r20, r21, r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return r0
    }

    public final boolean component1() {
            r1 = this;
            boolean r0 = r1.enabled
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
            r1 = this;
            java.lang.String r0 = r1.primaryDonateUrl
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
            r1 = this;
            java.lang.String r0 = r1.primaryButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
            r1 = this;
            java.lang.String r0 = r1.secondaryDonateUrl
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
            r1 = this;
            java.lang.String r0 = r1.secondaryButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
            r1 = this;
            java.lang.String r0 = r1.adSupportUrl
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component15() {
            r1 = this;
            java.lang.String r0 = r1.adSupportButtonText
            return r0
    }

    public final int component16() {
            r1 = this;
            int r0 = r1.cooldownHours
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component17() {
            r1 = this;
            java.lang.String r0 = r1.cooldownScope
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
            r1 = this;
            java.lang.String r0 = r1.extensionName
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
            r1 = this;
            java.lang.String r0 = r1.month
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
            r1 = this;
            java.lang.String r0 = r1.title
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
            r1 = this;
            java.lang.String r0 = r1.description
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
            r1 = this;
            java.lang.String r0 = r1.currency
            return r0
    }

    public final double component7() {
            r2 = this;
            double r0 = r2.targetAmount
            return r0
    }

    public final double component8() {
            r2 = this;
            double r0 = r2.currentAmount
            return r0
    }

    public final int component9() {
            r1 = this;
            int r0 = r1.supportersCount
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final com.phisher98.donation.DonationConfig copy(boolean r21, @org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.NotNull java.lang.String r26, double r27, double r29, int r31, @org.jetbrains.annotations.NotNull java.lang.String r32, @org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull java.lang.String r34, @org.jetbrains.annotations.NotNull java.lang.String r35, @org.jetbrains.annotations.NotNull java.lang.String r36, @org.jetbrains.annotations.NotNull java.lang.String r37, int r38, @org.jetbrains.annotations.NotNull java.lang.String r39) {
            r20 = this;
            com.phisher98.donation.DonationConfig r0 = new com.phisher98.donation.DonationConfig
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r8) {
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L4
            return r0
        L4:
            boolean r1 = r8 instanceof com.phisher98.donation.DonationConfig
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r8
            com.phisher98.donation.DonationConfig r1 = (com.phisher98.donation.DonationConfig) r1
            boolean r3 = r7.enabled
            boolean r4 = r1.enabled
            if (r3 == r4) goto L14
            return r2
        L14:
            java.lang.String r3 = r7.extensionName
            java.lang.String r4 = r1.extensionName
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L1f
            return r2
        L1f:
            java.lang.String r3 = r7.month
            java.lang.String r4 = r1.month
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L2a
            return r2
        L2a:
            java.lang.String r3 = r7.title
            java.lang.String r4 = r1.title
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L35
            return r2
        L35:
            java.lang.String r3 = r7.description
            java.lang.String r4 = r1.description
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L40
            return r2
        L40:
            java.lang.String r3 = r7.currency
            java.lang.String r4 = r1.currency
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L4b
            return r2
        L4b:
            double r3 = r7.targetAmount
            double r5 = r1.targetAmount
            int r3 = java.lang.Double.compare(r3, r5)
            if (r3 == 0) goto L56
            return r2
        L56:
            double r3 = r7.currentAmount
            double r5 = r1.currentAmount
            int r3 = java.lang.Double.compare(r3, r5)
            if (r3 == 0) goto L61
            return r2
        L61:
            int r3 = r7.supportersCount
            int r4 = r1.supportersCount
            if (r3 == r4) goto L68
            return r2
        L68:
            java.lang.String r3 = r7.primaryDonateUrl
            java.lang.String r4 = r1.primaryDonateUrl
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L73
            return r2
        L73:
            java.lang.String r3 = r7.primaryButtonText
            java.lang.String r4 = r1.primaryButtonText
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L7e
            return r2
        L7e:
            java.lang.String r3 = r7.secondaryDonateUrl
            java.lang.String r4 = r1.secondaryDonateUrl
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L89
            return r2
        L89:
            java.lang.String r3 = r7.secondaryButtonText
            java.lang.String r4 = r1.secondaryButtonText
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L94
            return r2
        L94:
            java.lang.String r3 = r7.adSupportUrl
            java.lang.String r4 = r1.adSupportUrl
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L9f
            return r2
        L9f:
            java.lang.String r3 = r7.adSupportButtonText
            java.lang.String r4 = r1.adSupportButtonText
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto Laa
            return r2
        Laa:
            int r3 = r7.cooldownHours
            int r4 = r1.cooldownHours
            if (r3 == r4) goto Lb1
            return r2
        Lb1:
            java.lang.String r3 = r7.cooldownScope
            java.lang.String r1 = r1.cooldownScope
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 != 0) goto Lbc
            return r2
        Lbc:
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAdSupportButtonText() {
            r1 = this;
            java.lang.String r0 = r1.adSupportButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAdSupportUrl() {
            r1 = this;
            java.lang.String r0 = r1.adSupportUrl
            return r0
    }

    public final int getCooldownHours() {
            r1 = this;
            int r0 = r1.cooldownHours
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCooldownScope() {
            r1 = this;
            java.lang.String r0 = r1.cooldownScope
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrency() {
            r1 = this;
            java.lang.String r0 = r1.currency
            return r0
    }

    public final double getCurrentAmount() {
            r2 = this;
            double r0 = r2.currentAmount
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
            r1 = this;
            java.lang.String r0 = r1.description
            return r0
    }

    public final boolean getEnabled() {
            r1 = this;
            boolean r0 = r1.enabled
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getExtensionName() {
            r1 = this;
            java.lang.String r0 = r1.extensionName
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMonth() {
            r1 = this;
            java.lang.String r0 = r1.month
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrimaryButtonText() {
            r1 = this;
            java.lang.String r0 = r1.primaryButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrimaryDonateUrl() {
            r1 = this;
            java.lang.String r0 = r1.primaryDonateUrl
            return r0
    }

    public final int getProgressPercentage() {
            r6 = this;
            double r0 = r6.targetAmount
            r2 = 0
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L1a
            double r0 = r6.currentAmount
            double r2 = r6.targetAmount
            double r0 = r0 / r2
            r2 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r0 = r0 * r2
            int r0 = (int) r0
            r1 = 100
            int r4 = kotlin.ranges.RangesKt.coerceIn(r0, r4, r1)
            goto L1b
        L1a:
        L1b:
            return r4
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSecondaryButtonText() {
            r1 = this;
            java.lang.String r0 = r1.secondaryButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSecondaryDonateUrl() {
            r1 = this;
            java.lang.String r0 = r1.secondaryDonateUrl
            return r0
    }

    public final int getSupportersCount() {
            r1 = this;
            int r0 = r1.supportersCount
            return r0
    }

    public final double getTargetAmount() {
            r2 = this;
            double r0 = r2.targetAmount
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
            r1 = this;
            java.lang.String r0 = r1.title
            return r0
    }

    public int hashCode() {
            r4 = this;
            boolean r0 = r4.enabled
            int r0 = com.phisher98.donation.DonationConfig$$ExternalSyntheticBackport0.m(r0)
            int r1 = r0 * 31
            java.lang.String r2 = r4.extensionName
            int r2 = r2.hashCode()
            int r1 = r1 + r2
            int r0 = r1 * 31
            java.lang.String r2 = r4.month
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            int r1 = r0 * 31
            java.lang.String r2 = r4.title
            int r2 = r2.hashCode()
            int r1 = r1 + r2
            int r0 = r1 * 31
            java.lang.String r2 = r4.description
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            int r1 = r0 * 31
            java.lang.String r2 = r4.currency
            int r2 = r2.hashCode()
            int r1 = r1 + r2
            int r0 = r1 * 31
            double r2 = r4.targetAmount
            int r2 = com.phisher98.donation.DonationConfig$$ExternalSyntheticBackport1.m(r2)
            int r0 = r0 + r2
            int r1 = r0 * 31
            double r2 = r4.currentAmount
            int r2 = com.phisher98.donation.DonationConfig$$ExternalSyntheticBackport1.m(r2)
            int r1 = r1 + r2
            int r0 = r1 * 31
            int r2 = r4.supportersCount
            int r0 = r0 + r2
            int r1 = r0 * 31
            java.lang.String r2 = r4.primaryDonateUrl
            int r2 = r2.hashCode()
            int r1 = r1 + r2
            int r0 = r1 * 31
            java.lang.String r2 = r4.primaryButtonText
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            int r1 = r0 * 31
            java.lang.String r2 = r4.secondaryDonateUrl
            int r2 = r2.hashCode()
            int r1 = r1 + r2
            int r0 = r1 * 31
            java.lang.String r2 = r4.secondaryButtonText
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            int r1 = r0 * 31
            java.lang.String r2 = r4.adSupportUrl
            int r2 = r2.hashCode()
            int r1 = r1 + r2
            int r0 = r1 * 31
            java.lang.String r2 = r4.adSupportButtonText
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            int r1 = r0 * 31
            int r2 = r4.cooldownHours
            int r1 = r1 + r2
            int r0 = r1 * 31
            java.lang.String r2 = r4.cooldownScope
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            return r0
    }

    public final boolean isGoalAchieved() {
            r5 = this;
            double r0 = r5.targetAmount
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L12
            double r0 = r5.currentAmount
            double r2 = r5.targetAmount
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L12
            r0 = 1
            goto L13
        L12:
            r0 = 0
        L13:
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
            r21 = this;
            r0 = r21
            boolean r1 = r0.enabled
            java.lang.String r2 = r0.extensionName
            java.lang.String r3 = r0.month
            java.lang.String r4 = r0.title
            java.lang.String r5 = r0.description
            java.lang.String r6 = r0.currency
            double r7 = r0.targetAmount
            double r9 = r0.currentAmount
            int r11 = r0.supportersCount
            java.lang.String r12 = r0.primaryDonateUrl
            java.lang.String r13 = r0.primaryButtonText
            java.lang.String r14 = r0.secondaryDonateUrl
            java.lang.String r15 = r0.secondaryButtonText
            r16 = r15
            java.lang.String r15 = r0.adSupportUrl
            r17 = r15
            java.lang.String r15 = r0.adSupportButtonText
            r18 = r15
            int r15 = r0.cooldownHours
            r19 = r15
            java.lang.String r15 = r0.cooldownScope
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r20 = r15
            java.lang.String r15 = "DonationConfig(enabled="
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", extensionName="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = ", month="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = ", title="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r1 = ", description="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r1 = ", currency="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r1 = ", targetAmount="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r1 = ", currentAmount="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r1 = ", supportersCount="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r1 = ", primaryDonateUrl="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r12)
            java.lang.String r1 = ", primaryButtonText="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r1 = ", secondaryDonateUrl="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r14)
            java.lang.String r1 = ", secondaryButtonText="
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r16
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", adSupportUrl="
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r17
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", adSupportButtonText="
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r18
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", cooldownHours="
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r19
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", cooldownScope="
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r20
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
    }
}
