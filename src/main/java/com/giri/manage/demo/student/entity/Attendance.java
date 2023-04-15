package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attend")
public class Attendance {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="subject")
		private String sub;
		@Override
		public String toString() {
			return "Attendance [id=" + id + ", sub=" + sub + ", dates=" + dates + ", a=" + a + ", b=" + b + ", c=" + c
					+ ", d=" + d + ", e=" + e + ", f=" + f + ", g=" + g + ", h=" + h + ", i=" + i + ", j=" + j + ", k="
					+ k + ", l=" + l + ", m=" + m + ", n=" + n + ", o=" + o + ", p=" + p + ", q=" + q + ", r=" + r
					+ ", s=" + s + ", t=" + t + ", u=" + u + ", v=" + v + ", w=" + w + ", x=" + x + ", y=" + y + ", z="
					+ z + ", a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + ", a4=" + a4 + ", a5=" + a5 + ", a6=" + a6
					+ ", a7=" + a7 + ", a8=" + a8 + ", a9=" + a9 + ", a10=" + a10 + ", a11=" + a11 + ", a12=" + a12
					+ ", a13=" + a13 + ", a14=" + a14 + ", a15=" + a15 + ", a16=" + a16 + ", a17=" + a17 + ", a18="
					+ a18 + ", a19=" + a19 + ", a20=" + a20 + ", a21=" + a21 + ", a22=" + a22 + ", a23=" + a23
					+ ", a24=" + a24 + ", a25=" + a25 + ", a26=" + a26 + ", a27=" + a27 + ", a28=" + a28 + ", a29="
					+ a29 + ", a30=" + a30 + ", a31=" + a31 + ", a32=" + a32 + ", a33=" + a33 + ", a34=" + a34
					+ ", a35=" + a35 + ", a36=" + a36 + ", a37=" + a37 + ", a38=" + a38 + ", a39=" + a39 + ", a40="
					+ a40 + ", a41=" + a41 + ", a42=" + a42 + ", a43=" + a43 + ", a44=" + a44 + ", present=" + present
					+ ", absent=" + absent + "]";
		}
		@Column(name="dates")
		private String dates;
		@Column(name="_1")
		private String a;
		@Column(name="_2")
		private String b;
		@Column(name="_3")
		private String c;
		@Column(name="_4")
		private String d;
		@Column(name="_5")
		private String e;
		@Column(name="_6")
		private String f;
		@Column(name="_7")
		private String g;
		@Column(name="_8")
		private String h;
		@Column(name="_9")
		private String i;
		@Column(name="_10")
		private String j;
		@Column(name="_11")
		private String k;
		@Column(name="_12")
		private String l;
		@Column(name="_13")
		private String m;
		@Column(name="_14")
		private String n;
		@Column(name="_15")
		private String o;
		@Column(name="_16")
		private String p;
		@Column(name="_17")
		private String q;
		@Column(name="_18")
		private String r;
		@Column(name="_19")
		private String s;
		@Column(name="_20")
		private String t;
		@Column(name="_21")
		private String u;
		@Column(name="_22")
		private String v;
		@Column(name="_23")
		private String w;
		@Column(name="_24")
		private String x;
		@Column(name="_25")
		private String y;
		@Column(name="_26")
		private String z;
		@Column(name="_28")
		private String a1;
		@Column(name="_29")
		private String a2;
		@Column(name="_30")
		private String a3;
		@Column(name="_31")
		private String a4;
		@Column(name="_32")
		private String a5;
		@Column(name="_33")
		private String a6;
		@Column(name="_34")
		private String a7;
		@Column(name="_35")
		private String a8;
		@Column(name="_36")
		private String a9;
		@Column(name="_37")
		private String a10;
		@Column(name="_38")
		private String a11;
		@Column(name="_39")
		private String a12;
		@Column(name="_40")
		private String a13;
		@Column(name="_41")
		private String a14;
		@Column(name="_42")
		private String a15;
		@Column(name="_43")
		private String a16;
		@Column(name="_44")
		private String a17;
		@Column(name="_45")
		private String a18;
		@Column(name="_46")
		private String a19;
		@Column(name="_47")
		private String a20;
		@Column(name="_48")
		private String a21;
		@Column(name="_49")
		private String a22;
		@Column(name="_50")
		private String a23;
		@Column(name="_51")
		private String a24;
		@Column(name="_52")
		private String a25;
		@Column(name="_53")
		private String a26;
		@Column(name="_54")
		private String a27;
		@Column(name="_55")
		private String a28;
		@Column(name="_56")
		private String a29;
		@Column(name="_57")
		private String a30;
		@Column(name="_58")
		private String a31;
		@Column(name="_59")
		private String a32;
		@Column(name="_60")
		private String a33;
		@Column(name="_61")
		private String a34;
		@Column(name="_62")
		private String a35;
		@Column(name="_63")
		private String a36;
		@Column(name="_64")
		private String a37;
		@Column(name="_65")
		private String a38;
		@Column(name="_66")
		private String a39;
		@Column(name="_67")
		private String a40;
		@Column(name="_68")
		private String a41;
		@Column(name="_69")
		private String a42;
		@Column(name="_70")
		private String a43;
		@Column(name="_71")
		private String a44;
		@Column(name="present")
		private int present;
		@Column(name="absent")
		private int absent;
		@Column(name="hour")
		private String hour;
		public Attendance() {
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSub() {
			return sub;
		}
		public void setSub(String sub) {
			this.sub = sub;
		}
		public String getDates() {
			return dates;
		}
		public void setDates(String dates) {
			this.dates = dates;
		}
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
		public String getC() {
			return c;
		}
		public void setC(String c) {
			this.c = c;
		}
		public String getD() {
			return d;
		}
		public void setD(String d) {
			this.d = d;
		}
		public String getE() {
			return e;
		}
		public void setE(String e) {
			this.e = e;
		}
		public String getF() {
			return f;
		}
		public void setF(String f) {
			this.f = f;
		}
		public String getG() {
			return g;
		}
		public void setG(String g) {
			this.g = g;
		}
		public String getH() {
			return h;
		}
		public void setH(String h) {
			this.h = h;
		}
		public String getI() {
			return i;
		}
		public void setI(String i) {
			this.i = i;
		}
		public String getJ() {
			return j;
		}
		public void setJ(String j) {
			this.j = j;
		}
		public String getK() {
			return k;
		}
		public void setK(String k) {
			this.k = k;
		}
		public String getL() {
			return l;
		}
		public void setL(String l) {
			this.l = l;
		}
		public String getM() {
			return m;
		}
		public void setM(String m) {
			this.m = m;
		}
		public String getN() {
			return n;
		}
		public void setN(String n) {
			this.n = n;
		}
		public String getO() {
			return o;
		}
		public void setO(String o) {
			this.o = o;
		}
		public String getP() {
			return p;
		}
		public void setP(String p) {
			this.p = p;
		}
		public String getQ() {
			return q;
		}
		public void setQ(String q) {
			this.q = q;
		}
		public String getR() {
			return r;
		}
		public void setR(String r) {
			this.r = r;
		}
		public String getS() {
			return s;
		}
		public void setS(String s) {
			this.s = s;
		}
		public String getT() {
			return t;
		}
		public void setT(String t) {
			this.t = t;
		}
		public String getU() {
			return u;
		}
		public void setU(String u) {
			this.u = u;
		}
		public String getV() {
			return v;
		}
		public void setV(String v) {
			this.v = v;
		}
		public String getW() {
			return w;
		}
		public void setW(String w) {
			this.w = w;
		}
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		public String getZ() {
			return z;
		}
		public void setZ(String z) {
			this.z = z;
		}
		public String getA1() {
			return a1;
		}
		public void setA1(String a1) {
			this.a1 = a1;
		}
		public String getA2() {
			return a2;
		}
		public void setA2(String a2) {
			this.a2 = a2;
		}
		public String getA3() {
			return a3;
		}
		public void setA3(String a3) {
			this.a3 = a3;
		}
		public String getA4() {
			return a4;
		}
		public void setA4(String a4) {
			this.a4 = a4;
		}
		public String getA5() {
			return a5;
		}
		public void setA5(String a5) {
			this.a5 = a5;
		}
		public String getA6() {
			return a6;
		}
		public void setA6(String a6) {
			this.a6 = a6;
		}
		public String getA7() {
			return a7;
		}
		public void setA7(String a7) {
			this.a7 = a7;
		}
		public String getA8() {
			return a8;
		}
		public void setA8(String a8) {
			this.a8 = a8;
		}
		public String getA9() {
			return a9;
		}
		public void setA9(String a9) {
			this.a9 = a9;
		}
		public String getA10() {
			return a10;
		}
		public void setA10(String a10) {
			this.a10 = a10;
		}
		public String getA11() {
			return a11;
		}
		public void setA11(String a11) {
			this.a11 = a11;
		}
		public String getA12() {
			return a12;
		}
		public void setA12(String a12) {
			this.a12 = a12;
		}
		public String getA13() {
			return a13;
		}
		public void setA13(String a13) {
			this.a13 = a13;
		}
		public String getA14() {
			return a14;
		}
		public void setA14(String a14) {
			this.a14 = a14;
		}
		public String getA15() {
			return a15;
		}
		public void setA15(String a15) {
			this.a15 = a15;
		}
		public String getA16() {
			return a16;
		}
		public void setA16(String a16) {
			this.a16 = a16;
		}
		public String getA17() {
			return a17;
		}
		public void setA17(String a17) {
			this.a17 = a17;
		}
		public String getA18() {
			return a18;
		}
		public void setA18(String a18) {
			this.a18 = a18;
		}
		public String getA19() {
			return a19;
		}
		public void setA19(String a19) {
			this.a19 = a19;
		}
		public String getA20() {
			return a20;
		}
		public void setA20(String a20) {
			this.a20 = a20;
		}
		public String getA21() {
			return a21;
		}
		public void setA21(String a21) {
			this.a21 = a21;
		}
		public String getA22() {
			return a22;
		}
		public void setA22(String a22) {
			this.a22 = a22;
		}
		public String getA23() {
			return a23;
		}
		public void setA23(String a23) {
			this.a23 = a23;
		}
		public String getA24() {
			return a24;
		}
		public void setA24(String a24) {
			this.a24 = a24;
		}
		public String getA25() {
			return a25;
		}
		public void setA25(String a25) {
			this.a25 = a25;
		}
		public String getA26() {
			return a26;
		}
		public void setA26(String a26) {
			this.a26 = a26;
		}
		public String getA27() {
			return a27;
		}
		public void setA27(String a27) {
			this.a27 = a27;
		}
		public String getA28() {
			return a28;
		}
		public void setA28(String a28) {
			this.a28 = a28;
		}
		public String getA29() {
			return a29;
		}
		public void setA29(String a29) {
			this.a29 = a29;
		}
		public String getA30() {
			return a30;
		}
		public void setA30(String a30) {
			this.a30 = a30;
		}
		public String getA31() {
			return a31;
		}
		public void setA31(String a31) {
			this.a31 = a31;
		}
		public String getA32() {
			return a32;
		}
		public void setA32(String a32) {
			this.a32 = a32;
		}
		public String getA33() {
			return a33;
		}
		public void setA33(String a33) {
			this.a33 = a33;
		}
		public String getA34() {
			return a34;
		}
		public void setA34(String a34) {
			this.a34 = a34;
		}
		public String getA35() {
			return a35;
		}
		public void setA35(String a35) {
			this.a35 = a35;
		}
		public String getA36() {
			return a36;
		}
		public void setA36(String a36) {
			this.a36 = a36;
		}
		public String getA38() {
			return a38;
		}
		
		public String getA37() {
			return a37;
		}
		public void setA37(String a37) {
			this.a37 = a37;
		}
		public void setA38(String a38) {
			this.a38 = a38;
		}
		public String getA39() {
			return a39;
		}
		public void setA39(String a39) {
			this.a39 = a39;
		}
		public String getA40() {
			return a40;
		}
		public void setA40(String a40) {
			this.a40 = a40;
		}
		public String getA41() {
			return a41;
		}
		public void setA41(String a41) {
			this.a41 = a41;
		}
		public String getA42() {
			return a42;
		}
		public void setA42(String a42) {
			this.a42 = a42;
		}
		public String getA43() {
			return a43;
		}
		public void setA43(String a43) {
			this.a43 = a43;
		}
		public String getA44() {
			return a44;
		}
		public void setA44(String a44) {
			this.a44 = a44;
		}
		
		public int getPresent() {
			return present;
		}
		public void setPresent(int present) {
			this.present = present;
		}
		public int getAbsent() {
			return absent;
		}
		public void setAbsent(int absent) {
			this.absent = absent;
		}
		public String getHour() {
			return hour;
		}
		public void setHour(String hour) {
			this.hour = hour;
		}
		public Attendance(int id, String sub, String dates, String a, String b, String c, String d, String e, String f,
				String g, String h, String i, String j, String k, String l, String m, String n, String o, String p,
				String q, String r, String s, String t, String u, String v, String w, String x, String y, String z,
				String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8, String a9,
				String a10, String a11, String a12, String a13, String a14, String a15, String a16, String a17,
				String a18, String a19, String a20, String a21, String a22, String a23, String a24, String a25,
				String a26, String a27, String a28, String a29, String a30, String a31, String a32, String a33,
				String a34, String a35, String a36, String a37, String a38, String a39, String a40, String a41, String a42,
				String a43, String a44, int present, int absent, String hour) {
			super();
			this.id = id;
			this.sub = sub;
			this.dates = dates;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
			this.g = g;
			this.h = h;
			this.i = i;
			this.j = j;
			this.k = k;
			this.l = l;
			this.m = m;
			this.n = n;
			this.o = o;
			this.p = p;
			this.q = q;
			this.r = r;
			this.s = s;
			this.t = t;
			this.u = u;
			this.v = v;
			this.w = w;
			this.x = x;
			this.y = y;
			this.z = z;
			this.a1 = a1;
			this.a2 = a2;
			this.a3 = a3;
			this.a4 = a4;
			this.a5 = a5;
			this.a6 = a6;
			this.a7 = a7;
			this.a8 = a8;
			this.a9 = a9;
			this.a10 = a10;
			this.a11 = a11;
			this.a12 = a12;
			this.a13 = a13;
			this.a14 = a14;
			this.a15 = a15;
			this.a16 = a16;
			this.a17 = a17;
			this.a18 = a18;
			this.a19 = a19;
			this.a20 = a20;
			this.a21 = a21;
			this.a22 = a22;
			this.a23 = a23;
			this.a24 = a24;
			this.a25 = a25;
			this.a26 = a26;
			this.a27 = a27;
			this.a28 = a28;
			this.a29 = a29;
			this.a30 = a30;
			this.a31 = a31;
			this.a32 = a32;
			this.a33 = a33;
			this.a34 = a34;
			this.a35 = a35;
			this.a36 = a36;
			this.a37 = a37;
			this.a38 = a38;
			this.a39 = a39;
			this.a40 = a40;
			this.a41 = a41;
			this.a42 = a42;
			this.a43 = a43;
			this.a44 = a44;
			this.present = present;
			this.absent = absent;
			this.hour = hour;
		}
		
}
