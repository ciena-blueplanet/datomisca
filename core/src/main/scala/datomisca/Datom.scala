/*
 * Copyright 2012 Pellucid and Zenexity
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package datomisca


final class Datom(val underlying: datomic.Datom) extends AnyVal {

  def id:     Long    = underlying.e.asInstanceOf[Long]
  def attrId: Int     = underlying.a.asInstanceOf[Integer]
  def value:  Any     = Convert.toScala(underlying.v)
  def tx:     Long    = underlying.tx.asInstanceOf[Long]
  def added:  Boolean = underlying.added

}

object Datom {
   def unapply(da: Datom): Option[(Long, Int, Any, Long, Boolean)] =
    Some((da.id,da.attrId,da.value,da.tx,da.added))
}
